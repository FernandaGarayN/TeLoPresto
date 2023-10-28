package cl.duoc.newrentacar.api.endpoint;


import cl.duoc.newrentacar.api.endpoint.model.Payment;
import cl.duoc.newrentacar.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @GetMapping("/payments/{username}")
    public ResponseEntity<List<Payment>> getByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(paymentService.findByUserName(username));
    }

    @PostMapping("/payments")
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        paymentService.save(payment);
        return ResponseEntity.ok(payment);
    }
}
