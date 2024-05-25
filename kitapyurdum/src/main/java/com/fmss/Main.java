package com.fmss;

import com.fmss.model.*;
import com.fmss.model.enums.AccountType;
import com.fmss.repository.CustomerRepository;
import com.fmss.repository.InvoiceRepository;
import com.fmss.repository.ProductRepository;
import com.fmss.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();
        PublisherService publisherService = new PublisherService();
        CategoryService categoryService = new CategoryService();
        ProductService productService = new ProductService(publisherService, categoryService);
        InvoiceRepository invoiceRepository = new InvoiceRepository();
        InvoiceService invoiceService = new InvoiceService(invoiceRepository);


        //-- customer
        System.out.println("CUSTOMER LIST\n");

            Customer customer1 = customerService.save("cem", "dırman", LocalDate.of(1997, 5, 20),"cem@gmail.com", "password123");
            Customer customer2 = customerService.save("bertuğ", "inal", LocalDate.of(2000, 8, 6),"bert@gmail.com", "password123");
            Customer customer3 = customerService.save("veli", "dırman", LocalDate.of(1996, 3, 12),"veli@gmail.com", "password456");
            Customer customer4 = customerService.save("veli", "dırman", LocalDate.of(2005, 7, 2),"veli@gmail.com", "password789");

        customer1.setAge(customer1.calculateAge());
        customer2.setAge(customer2.calculateAge());
        customer3.setAge(customer3.calculateAge());
        customer4.setAge(customer4.calculateAge());

        System.out.println("cem's age is: " + customer1.calculateAge());


        customerService.changeAccountType("cem@gmail.com", AccountType.GOLD);
        customerService.changeAccountTypeByCredit("veli@gmail.com", 4500);


        customerService.getCustomerList().forEach(System.out::println);



        //-- publisher
        System.out.println("\nPUBLISHER LIST\n");


        Publisher publisher1 = publisherService.savePublisher("DERGAH YAYINLARI", LocalDate.now().minusYears(1));
        Publisher publisher2 = publisherService.savePublisher("CAN YAYINLARI", LocalDate.now().minusYears(10));
        System.out.println(publisherService.hashCode());

        publisherService.getAllPublishers().forEach(System.out::println);


        //-- category
        System.out.println("\nCATEGORY LIST\n");


        Category category1 = categoryService.save("Roman");
        Category category2 = categoryService.save("Gezi");
        Category category3 = categoryService.save("Hikaye");

        categoryService.getAll().forEach(System.out::println);


        //-- product
        System.out.println("\nPRODUCT LIST\n");

        Product product1 = productService.save("Şeker Portakalı", new BigDecimal("100.00"),
                "Ne güzel bir şeker portakalı fidanıymış bu!", 1000,"CAN YAYINLARI", "Roman");

        Product product2 = productService.save("Saatleri Ayarlama Enstitüsü", new BigDecimal("200.00"),
                "Ahmet Hamdi Tanpınar’ın şiiri sembolist bir ifade üzerine kurulmuştur.",  2000, "CAN YAYINLARI", "Gezi");

        Product product3 = productService.save("Saatleri Ayarlama Enstitüsü", new BigDecimal("2040.00"),
                "Ahmet Hamdi Tanpınar’ın şiiri sembolist bir ifade üzerine kurulmuştur.", 500,"CAN YAYINLARI", "Hikaye");

        Product product4 = productService.save("Küçük Prens", new BigDecimal("12.88"),
                "Ne güzel bir şeker portakalı fidanıymış bu!",1200,"DERGAH YAYINLARI", "Roman");

        Product product5 = productService.save("Küçük Prens", new BigDecimal("300.00"),
                "Ne güzel bir şeker portakalı fidanıymış bu!",700,"DERGAH YAYINLARI", "Gezi");

        productService.listAll();



        //--order
        System.out.println("\n ORDER LIST \n");

        for (Customer c : customerService.getCustomerList()) {

        }

        List<Product> productList1 = Arrays.asList(product1, product2, product5);
        List<Product> productList2 = Arrays.asList(product3);

        Order order1 = orderService.add(productList1, OrderService.generateOrderCode(), customer1);
        Order order2 = orderService.add(productList2, OrderService.generateOrderCode(), customer2);





        orderService.getAll().forEach(System.out::println);



        //--invoice
        System.out.println("\nINVOİCE LIST\n");

        invoiceService.createInvoice(order1, customer1);
        invoiceService.createInvoice(order2, customer2);


        System.out.println("The customer earns 2% points on the total amount of each order!");
        BigDecimal customer1OrderTotal = invoiceService.getAll()
                .stream()
                .filter(invoice -> invoice.getCustomer().getEmail().equals(customer1.getEmail()))
                .map(invoice -> invoice.getTotalAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);

        customerService.addCreditForOrder(customer1.getEmail(), customer1OrderTotal);
        System.out.println("Customer1 credit: " + customer1.getCredit());

        invoiceService.getAll().forEach(System.out::println);



        System.out.println("\nOUTPUT\n");
        System.out.println("Customer numbers: " + customerService.getCustomerList().size());
        System.out.println("Number of products purchased by customers named 'cem': " + orderService.getAll().stream()
                .filter(order -> order.getCustomer().getName().toLowerCase().equals("cem"))
                .mapToInt(order -> order.getProductList().size()).sum());

        System.out.println("Total shopping amount of customers whose name is Cem and who are younger than 30 and older than 25: " +invoiceService.getAll().stream()
                .filter(invoice -> Period.between(invoice.getCustomer().getBirth(), LocalDate.now()).getYears() > 25)
                .filter(invoice -> Period.between(invoice.getCustomer().getBirth(), LocalDate.now()).getYears() < 30)
                .filter(invoice -> invoice.getCustomer().getName().toLowerCase().equals("cem"))
                .map(invoice -> invoice.getTotalAmount()).reduce(BigDecimal.ZERO, BigDecimal::add));


        System.out.println("Invoices over 1500 TL in the system: ");
        invoiceService.getAll().stream()
                .filter(invoice -> invoice.getTotalAmount().compareTo(BigDecimal.valueOf(1500)) == 1)
                .toList().forEach(System.out::println);

    }
}