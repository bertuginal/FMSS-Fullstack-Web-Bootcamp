package com.fmss.model;

import com.fmss.model.enums.AccountType;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Customer {
    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDate birth;
    private Integer age;
    private Integer credit;
    private String phoneNumber;
    private Set<Address> address;
    private Boolean isActive;
    private AccountType accountType;
    private List<Order> orderList;

    private Customer(){

    }

    public Customer(String name, String surname, LocalDate birth, String email, String password){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birth = birth;
        this.credit = 0;
        this.password = password;
        this.isActive = true;
        this.accountType=AccountType.STANDARD;
        this.orderList = new ArrayList<>();
    }

    public Customer(String name, String surname, String email, String password, Integer credit, String phoneNumber, LocalDate birth, Integer age, Set<Address> address, List<Order> orderList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.credit = credit;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.age = age;
        this.address = address;
        this.orderList = orderList;
        this.isActive = true;
        this.accountType=AccountType.STANDARD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCredit() { return credit; }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public List<Order> getOrderList() {
        if (orderList == null) {
            return new ArrayList<>();
        }
        return orderList;
    }
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void addCredit(int credit) {
        this.credit += credit;
    }

    public int calculateAge() {
        if (birth == null) {
            return 0;
        }
        return Period.between(birth, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\n' +
                "surname='" + surname + '\n' +
                "age='" + age + '\n' +
                "birth='" + birth + '\n' +
                "email='" + email + '\n' +
                "password='" + password + '\n' +
                "credit=" + credit + '\n' +
                "phoneNumber='" + phoneNumber + '\n' +
                "isActive=" + isActive + '\n' +
                "accountType=" + accountType + '\n' +
                '}';
    }

}
