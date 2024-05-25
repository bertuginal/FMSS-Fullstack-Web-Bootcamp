package com.fmss.repository;

import com.fmss.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private static CustomerRepository instance;

    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }

    private List<Customer> customerList = new ArrayList<>();

    public void createCustomer(Customer customer) { customerList.add(customer); }
    public List<Customer> getCustomerList() { return customerList; }

    public Optional<Customer> findByEmail(String email) {
        return customerList.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst();
    }
}
