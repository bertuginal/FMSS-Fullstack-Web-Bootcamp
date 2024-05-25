package com.fmss.factory;

import com.fmss.model.Category;
import com.fmss.model.Customer;
import com.fmss.model.Publisher;
import com.fmss.repository.*;
import com.fmss.service.*;

public class ServiceFactory {
    public static CustomerService createCustomerService() {
        return new CustomerService(CustomerRepository.getInstance());
    }

    public static PublisherService createPublisherService() {
        return new PublisherService(PublisherRepository.getInstance());
    }

    public static CategoryService createCategoryService() {
        return new CategoryService(CategoryRepository.getInstance());
    }

    public static ProductService createProductService() {
        return new ProductService(ProductRepository.getInstance());
    }

    public static OrderService createOrderService() {
        return new OrderService(OrderRepository.getInstance());
    }

    public static InvoiceService createInvoiceService() {
        return new InvoiceService(InvoiceRepository.getInstance());
    }


}
