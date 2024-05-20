package com.fmss;

import com.fmss.model.Customer;
import com.fmss.model.Order;
import com.fmss.model.Product;
import com.fmss.model.enums.AccountType;
import com.fmss.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        //-- customer
        System.out.println("CUSTOMER LIST\n");

        CustomerService customerService = new CustomerService();

        try {
            customerService.save("cem", "dırman", "cem@gmail.com", "password");
            customerService.save("erkam", "veli", "erkam@gmail.com", "password");
            customerService.save("veli", "dırman", "veli@gmail.com", "password");
            customerService.save("veli", "dırman", "veli@gmail.com", "password");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        customerService.changeAccountType("cem@gmail.com", AccountType.GOLD);
        customerService.changeAccountTypeByCredit("veli@gmail.com", 4500);

        customerService.getCustomerList().forEach(System.out::println);


        //-- publisher
        System.out.println("\nPUBLISHER LIST\n");

        PublisherService publisherService = new PublisherService();
        publisherService.savePublisher("DERGAH YAYINLARI", LocalDate.now().minusYears(1));
        publisherService.savePublisher("CAN YAYINLARI", LocalDate.now().minusYears(10));
        System.out.println(publisherService.hashCode());

        publisherService.getAllPublishers().forEach(System.out::println);

        //-- category
        System.out.println("\nCATEGORY LIST\n");

        CategoryService categoryService = new CategoryService();
        categoryService.save("Roman");
        categoryService.save("Gezi");
        categoryService.save("Hikaye");

        categoryService.getAll().forEach(System.out::println);


        //-- product
        System.out.println("\nPRODUCT LIST\n");

        ProductService productService = new ProductService(publisherService, categoryService);

        productService.save("Şeker Portakalı", new BigDecimal("90.20"),
                "Ne güzel bir şeker portakalı fidanıymış bu!", 1000,"CAN YAYINLARI", "Roman");

        productService.save("Saatleri Ayarlama Enstitüsü", new BigDecimal("240.00"),
                "Ahmet Hamdi Tanpınar’ın şiiri sembolist bir ifade üzerine kurulmuştur.",  2000, "CAN YAYINLARI", "Gezi");

        productService.save("Saatleri Ayarlama Enstitüsü", new BigDecimal("240.00"),
                "Ahmet Hamdi Tanpınar’ın şiiri sembolist bir ifade üzerine kurulmuştur.", 500,"CAN YAYINLARI", "Hikaye");

        productService.save("Küçük Prens", new BigDecimal("12.88"),
                "Ne güzel bir şeker portakalı fidanıymış bu!",1200,"DERGAH YAYINLARI", "Roman");

        productService.save("Küçük Prens", new BigDecimal("12.88"),
                "Ne güzel bir şeker portakalı fidanıymış bu!",700,"DERGAH YAYINLARI", "Gezi");

        productService.listAll();


        //order
        System.out.println("\n ORDER LIST \n");

        OrderService orderService = new OrderService();

        //orderService.add(productService.getAll(), "asdasd");


        // ödev email adresi verilen kullanıcının orderlerini getiren method
        //  listOrdersByEmail("cem@gmail.com");
    }

    /* ödev OrderService oluşturulacak
    private static void listOrdersByEmail(String email) {
        List<Order> orderList = customerList.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .flatMap(customer -> customer.getOrderList().stream())
                .toList();

        orderList.forEach(System.out::println);
    }

     */

    private static Order prepareOrder(List<Product> productList) {
        //Order order = new Order(); tercih etmiyoruz. çünkü direkt dönüş yapıyoruz.
        return new Order(productList, "order123");
    }

}