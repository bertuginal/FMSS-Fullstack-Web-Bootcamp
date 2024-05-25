package com.fmss.service;

import com.fmss.model.Customer;
import com.fmss.model.Invoice;
import com.fmss.model.Order;
import com.fmss.repository.InvoiceRepository;
import com.fmss.repository.PublisherRepository;

import java.util.List;
import java.util.Optional;

public class InvoiceService {
    private InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createInvoice(Order order, Customer customer){
        Invoice invoice = new Invoice(order, customer);
        invoiceRepository.save(invoice);
    }

    public Optional<Invoice> getInvoiceByCode(String invoiceCode){
        return invoiceRepository.findById(invoiceCode);
    }

    public List<Invoice> getAll(){
        return invoiceRepository.findAll();
    }
}
