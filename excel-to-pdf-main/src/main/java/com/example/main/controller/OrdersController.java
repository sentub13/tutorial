package com.example.main.controller;

import com.example.main.model.Orders;
import com.example.main.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @PostMapping
    public Orders createOrder(@RequestBody Orders order) {
        return ordersRepository.save(order);
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders order) {
        return ordersRepository.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        ordersRepository.deleteById(id);
    }
}
