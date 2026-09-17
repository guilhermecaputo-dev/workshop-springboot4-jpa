package com.educandoweb.course.controller;


import com.educandoweb.course.model.Order;
import com.educandoweb.course.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tb_order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable("id") Long id){
        return orderService.findById(id);
    }

}
