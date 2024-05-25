package com.fmss.repository;

import com.fmss.model.Category;
import com.fmss.model.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceRepository {

    private static InvoiceRepository instance;

    public static InvoiceRepository getInstance() {
        if (instance == null) {
            instance = new InvoiceRepository();
        }
        return instance;
    }

    private List<Invoice> invoiceList = new ArrayList<>();

    public void save(Invoice invoice) { invoiceList.add(invoice); }

    public Optional<Invoice> findById(String invoiceCode){
        return invoiceList
                .stream()
                .filter(invoice -> invoice.getInvoiceCode().equals(invoiceCode))
                .findFirst();
    }

    public List<Invoice> findAll(){
        return new ArrayList<>(invoiceList);
    }

}
