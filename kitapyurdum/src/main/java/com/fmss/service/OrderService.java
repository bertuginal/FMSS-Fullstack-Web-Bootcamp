package com.fmss.service;

import com.fmss.model.Order;
import com.fmss.model.Product;
import com.fmss.model.Publisher;
import com.fmss.repository.OrderRepository;

import java.util.List;

public class OrderService {

    private OrderRepository orderRepository = new OrderRepository();

    public void add(List<Product> products, String orderCode) {
        Order order = new Order(products, orderCode);
        orderRepository.add(order);
    }

    public List<Order> getAll() { return orderRepository.getAll(); }

}
