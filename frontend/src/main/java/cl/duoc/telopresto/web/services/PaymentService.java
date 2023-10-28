package cl.duoc.telopresto.web.services;

import cl.duoc.telopresto.web.apiclients.payment.PaymentClient;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PaymentService {
    private final PaymentClient paymentClient;
    public List<Payment> findByUsername(String username){
        return paymentClient.findByUsername(username);
    }
}
