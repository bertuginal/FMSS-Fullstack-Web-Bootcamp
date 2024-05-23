package com.fmss.model;

import com.fmss.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Order {
    private LocalDateTime createDate;
    private List<Product> productList;
    private String orderCode;
    private OrderStatus orderStatus;
    private Invoice invoice;
    private Customer customer;


    public Order(List<Product> productList, String orderCode, Customer customer) {
        this.orderCode = orderCode;
        this.customer = customer;
        this.createDate = LocalDateTime.now();
        this.productList = productList;
        this.orderStatus=OrderStatus.INITIAL;
        this.invoice = new Invoice(this, customer);
        customer.addOrder(this);
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
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


    public BigDecimal calculateTotalAmount() {
        return productList.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void addCreditToCustomer() {
        BigDecimal totalAmount = calculateTotalAmount();
        int points = totalAmount.multiply(new BigDecimal("0.02")).intValue();
        customer.addCredit(points);
    }

    @Override
    public String toString() {
        return "Order{" +
                "createDate=" + createDate + '\n' +
                "productList=" + productList + '\n' +
                "orderCode='" + orderCode + '\n' +
                "orderStatus=" + orderStatus + '\n' +
                '}';
    }
}
