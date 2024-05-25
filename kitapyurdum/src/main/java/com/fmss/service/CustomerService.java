package com.fmss.service;

import com.fmss.model.Customer;
import com.fmss.model.Order;
import com.fmss.model.Product;
import com.fmss.model.enums.AccountType;
import com.fmss.repository.CustomerRepository;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.*;

public class CustomerService {

    private CustomerRepository customerRepository = new CustomerRepository();

    public Customer save(String name, String surname, LocalDate age, String email, String password) throws Exception {
        Customer customer = new Customer(name, surname, age, email, password);
        hashPassword(customer.getPassword());
        System.out.println(password + " hashed -> " + hashPassword(customer.getPassword()));
        customer.setPassword(hashPassword(customer.getPassword()));
        for (Customer c : getCustomerList()) {
            if (c.getEmail().equals(customer.getEmail())){
                System.out.println("Customer email already created! -> " + customer.getEmail());
                return customer;
            }
        }
         customerRepository.createCustomer(customer);
         return customer;
    }


    public List<Customer> getCustomerList() { return customerRepository.getCustomerList(); }

    public void changeAccountType(String email, AccountType accountType) {
        Optional<Customer> foundCustomer = getCustomerList()
                .stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst();
        if (foundCustomer.isPresent()) {
            foundCustomer.get().setAccountType(accountType);
        }
    }

    public void changeAccountTypeByCredit(String email, Integer credit) {
        Optional<Customer> findCustomer = getCustomerList()
                .stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst();
        if (findCustomer.isPresent()) {
            if (credit >= 1000 && credit <= 1999) { findCustomer.get().setAccountType(AccountType.SILVER); }
            else if (credit >= 2000 && credit <=3999) { findCustomer.get().setAccountType(AccountType.GOLD); }
            else if (credit >= 4000) { findCustomer.get().setAccountType(AccountType.PLATINUM); }
            else { findCustomer.get().setAccountType(AccountType.STANDARD); }
        }
    }

    public void addCreditForOrder(String email, BigDecimal orderTotal) {
        Optional<Customer> findCustomer = getCustomerList()
                .stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst();
            Integer intValue = orderTotal.intValue();
            Integer creditEarned = (int) (intValue * 0.02);
            Integer customerCredit = findCustomer.get().getCredit();
            customerCredit += creditEarned;
            findCustomer.get().setCredit(customerCredit);
            changeAccountTypeByCredit(email, creditEarned);


    }


    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encodedHash);
    }





}
