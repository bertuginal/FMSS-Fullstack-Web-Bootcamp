package com.fmss.repository;

import com.fmss.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private static OrderRepository instance;

    public static OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepository();
        }
        return instance;
    }

    List<Order> orderList = new ArrayList<>();

    public void add(Order order) { orderList.add(order); }

    public List<Order> getAll(){ return orderList; }
}
