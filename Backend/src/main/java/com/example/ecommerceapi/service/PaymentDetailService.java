package com.example.ecommerceapi.service;

import com.example.ecommerceapi.exception.ResourceNotFoundException;
import com.example.ecommerceapi.model.PaymentDetail;
import com.example.ecommerceapi.repository.PaymentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentDetailService {

    @Autowired
    private PaymentDetailRepository paymentDetailRepository;

    public List<PaymentDetail> getAllPaymentDetails() {
        return paymentDetailRepository.findAll();
    }

    public PaymentDetail getPaymentDetailById(Long id) {
        return paymentDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PaymentDetail not found with id: " + id));
    }

    public PaymentDetail createPaymentDetail(PaymentDetail paymentDetail) {
        return paymentDetailRepository.save(paymentDetail);
    }

    public PaymentDetail updatePaymentDetail(Long id, PaymentDetail paymentDetailDetails) {
        PaymentDetail paymentDetail = paymentDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PaymentDetail not found with id: " + id));
        paymentDetail.setOrderDetail(paymentDetailDetails.getOrderDetail());
        paymentDetail.setAmount(paymentDetailDetails.getAmount());
        paymentDetail.setProvider(paymentDetailDetails.getProvider());
        paymentDetail.setStatus(paymentDetailDetails.getStatus());
        paymentDetail.setCreatedAt(paymentDetailDetails.getCreatedAt());
        paymentDetail.setUpdatedAt(paymentDetailDetails.getUpdatedAt());
        return paymentDetailRepository.save(paymentDetail);
    }

    public void deletePaymentDetail(Long id) {
        PaymentDetail paymentDetail = paymentDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PaymentDetail not found with id: " + id));
        paymentDetailRepository.delete(paymentDetail);
    }
}