package cl.duoc.newrentacar.api.service;

import cl.duoc.newrentacar.api.endpoint.model.Payment;
import cl.duoc.newrentacar.api.repository.PaymentRepository;
import cl.duoc.newrentacar.api.repository.ReservationRepository;
import cl.duoc.newrentacar.api.repository.model.PaymentEntity;
import cl.duoc.newrentacar.api.repository.model.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ReservationRepository reservationRepository;
    public List<Payment> findByUserName(String userName){
        List<PaymentEntity> paymentsByUserName=paymentRepository.findByReservationClientUsername(userName);
        List<Payment> payments= new ArrayList<>();
        for (PaymentEntity entity : paymentsByUserName) {
            payments.add(getPayment(entity));
        }
        return payments;
    }

  private Payment getPayment(PaymentEntity entity) {
    Payment payment = new Payment();
    payment.setId(entity.getId());
    payment.setReservationId(entity.getReservation().getId());
    payment.setType(entity.getType());
    payment.setAmount(entity.getAmount());
    payment.setPaymentDate(entity.getPaymentDate());
    return payment;
  }

  public Payment save(Payment payment) {
    ReservationEntity reservation = reservationRepository.findById(payment.getReservationId()).orElseThrow();

    PaymentEntity entity = new PaymentEntity();
    entity.setReservation(reservation);
    entity.setType(payment.getType());
    entity.setAmount(payment.getAmount());
    entity.setPaymentDate(payment.getPaymentDate());

    entity = paymentRepository.save(entity);

    payment.setId(entity.getId());
    return payment;
  }
}
