package com.fmss.repository;

import com.fmss.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    public void createCustomer(Customer customer) { customerList.add(customer); }
    public List<Customer> getCustomerList() { return customerList; }
}
