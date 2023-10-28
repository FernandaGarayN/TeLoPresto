package cl.duoc.newrentacar.api.service;

import cl.duoc.newrentacar.api.endpoint.model.Car;
import cl.duoc.newrentacar.api.endpoint.model.Payment;
import cl.duoc.newrentacar.api.endpoint.model.Reservation;
import cl.duoc.newrentacar.api.repository.PaymentRepository;
import cl.duoc.newrentacar.api.repository.ReservationRepository;
import cl.duoc.newrentacar.api.repository.model.CarEntity;
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
    public List<Payment> findByUserName(String userName){
        List<PaymentEntity> paymentsByUserName=paymentRepository.findByClientUsername(userName);
        List<Payment> payments= new ArrayList<>();
        for (PaymentEntity entity : paymentsByUserName) {
            payments.add(getPayment(entity));
        }
        return payments;
    }

    private Payment getPayment(PaymentEntity entity) {
        Payment payment=new Payment();
        payment.setId(entity.getId());
        payment.setReservationId(entity.getReservation());
        payment.setType(getType(entity.getType()));
        payment.setAmount(entity.getAmount());
        payment.setPaymentDate(entity.getPaymentDate());
        return payment;
    }

    public Payment save(Payment payment) {
        //agregar la logica para almacenar en BD con reservation repository
        return payment;
    }
}
