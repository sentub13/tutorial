package com.example.main.service;

import com.example.main.model.Orders;
import com.example.main.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public Optional<Orders> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }

    public Orders updateOrder(Long id, Orders order) {
        return ordersRepository.save(order);
    }

    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}
