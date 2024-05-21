package com.fmss.model;

import com.fmss.model.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Order {
    private LocalDateTime createDate;
    private Set<Product> productList;
    private String orderCode;
    private OrderStatus orderStatus;


    public Order(Set<Product> productList, String orderCode) {
        this.orderCode = orderCode;
        this.createDate = LocalDateTime.now();
        this.productList = productList;
        this.orderStatus=OrderStatus.INITIAL;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Set<Product> getProductList() {
        return productList;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "createDate=" + createDate +
                ", productList=" + productList +
                ", orderCode='" + orderCode + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
