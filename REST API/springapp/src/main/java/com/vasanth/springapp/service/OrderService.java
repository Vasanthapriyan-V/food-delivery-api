package com.vasanth.springapp.service;

import com.vasanth.springapp.Entity.OrderEntity;
import com.vasanth.springapp.exception.ResourceNotFoundException;
import com.vasanth.springapp.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity createOrder(OrderEntity order) {
        if (order.getTotalAmount() <= 0) {
            throw new IllegalArgumentException("Total amount must be greater than zero.");
        }
        return orderRepository.save(order);
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<OrderEntity> getOrderById(Long id) {
        return Optional.ofNullable(orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with ID " + id + " not found.")));
    }

    public Optional<OrderEntity> updateOrder(Long id, OrderEntity newOrder) {
        OrderEntity existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with ID " + id + " not found."));

        existingOrder.setCustomerName(newOrder.getCustomerName());
        existingOrder.setTotalAmount(newOrder.getTotalAmount());
        return Optional.of(orderRepository.save(existingOrder));
    }

    public boolean deleteOrder(Long id) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with ID " + id + " not found."));
        orderRepository.delete(order);
        return true;
    }
}
