package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.model.PaymentDetail;
import com.example.ecommerceapi.service.PaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-details")
public class PaymentDetailController {

    @Autowired
    private PaymentDetailService paymentDetailService;

    @GetMapping
    public List<PaymentDetail> getAllPaymentDetails() {
        return paymentDetailService.getAllPaymentDetails();
    }

    @GetMapping("/{id}")
    public PaymentDetail getPaymentDetailById(@PathVariable Long id) {
        return paymentDetailService.getPaymentDetailById(id);
    }

    @PostMapping
    public PaymentDetail createPaymentDetail(@RequestBody PaymentDetail paymentDetail) {
        return paymentDetailService.createPaymentDetail(paymentDetail);
    }

    @PutMapping("/{id}")
    public PaymentDetail updatePaymentDetail(@PathVariable Long id, @RequestBody PaymentDetail paymentDetailDetails) {
        return paymentDetailService.updatePaymentDetail(id, paymentDetailDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePaymentDetail(@PathVariable Long id) {
        paymentDetailService.deletePaymentDetail(id);
    }
}