package com.example.ecommerceapi.service;

import com.example.ecommerceapi.exception.ResourceNotFoundException;
import com.example.ecommerceapi.model.OrderDetail;
import com.example.ecommerceapi.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    public OrderDetail getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderDetail not found with id: " + id));
    }

    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public OrderDetail updateOrderDetail(Long id, OrderDetail orderDetailDetails) {
        OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderDetail not found with id: " + id));
        orderDetail.setPaymentId(orderDetailDetails.getPaymentId());
        orderDetail.setTotal(orderDetailDetails.getTotal());
        orderDetail.setCreatedAt(orderDetailDetails.getCreatedAt());
        orderDetail.setUpdatedAt(orderDetailDetails.getUpdatedAt());
        return orderDetailRepository.save(orderDetail);
    }

    public void deleteOrderDetail(Long id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderDetail not found with id: " + id));
        orderDetailRepository.delete(orderDetail);
    }
}