package com.fmss.model;

import java.math.BigDecimal;

public class Invoice {

    private String invoiceCode;
    private Order order;
    private Customer customer;
    private BigDecimal totalAmount;

    public Invoice(Order order, Customer customer) {
        this.invoiceCode = "INV-" + order.getOrderCode();
        this.order = order;
        this.customer = customer;
        this.totalAmount = order.calculateTotalAmount();
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceCode='" + invoiceCode + '\n' +
                "order=" + order + '\n' +
                "totalAmount=" + totalAmount + '\n' +
                '}';
    }
}
