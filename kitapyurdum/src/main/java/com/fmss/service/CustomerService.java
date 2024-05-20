package com.fmss.service;

import com.fmss.model.Customer;
import com.fmss.model.Product;
import com.fmss.model.enums.AccountType;
import com.fmss.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {

    private CustomerRepository customerRepository = new CustomerRepository();

    public void save(String name, String surname, String email, String password) throws Exception {
        Customer customer = new Customer(name, surname, email, password);
        for (Customer c : getCustomerList()) {
            if (c.getEmail().equals(customer.getEmail())){
                throw new Exception("Customer email already created! -> " + customer.getEmail());
            }
        }
        customerRepository.createCustomer(customer);
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
}
