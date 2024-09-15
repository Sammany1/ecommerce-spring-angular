package com.example.ecommerceapi.service;

import com.example.ecommerceapi.exception.ResourceNotFoundException;
import com.example.ecommerceapi.model.OrderItem;
import com.example.ecommerceapi.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItem not found with id: " + id));
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItemDetails) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItem not found with id: " + id));
        orderItem.setOrderDetail(orderItemDetails.getOrderDetail());
        orderItem.setProduct(orderItemDetails.getProduct());
        orderItem.setProductSku(orderItemDetails.getProductSku());
        orderItem.setQuantity(orderItemDetails.getQuantity());
        orderItem.setCreatedAt(orderItemDetails.getCreatedAt());
        orderItem.setUpdatedAt(orderItemDetails.getUpdatedAt());
        return orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItem not found with id: " + id));
        orderItemRepository.delete(orderItem);
    }
}