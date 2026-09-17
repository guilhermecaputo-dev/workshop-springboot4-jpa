package com.educandoweb.course.service;

import com.educandoweb.course.model.Order;
import com.educandoweb.course.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}
