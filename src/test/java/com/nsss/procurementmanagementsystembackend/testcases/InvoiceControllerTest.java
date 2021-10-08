//package com.nsss.procurementmanagementsystembackend.testcases;
//
//import com.nsss.procurementmanagementsystembackend.model.Invoice;
//import com.nsss.procurementmanagementsystembackend.model.OrderItem;
//import com.nsss.procurementmanagementsystembackend.model.Site;
//import com.nsss.procurementmanagementsystembackend.repository.InvoiceRepository;
//import com.nsss.procurementmanagementsystembackend.repository.SiteRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.annotation.Order;
//
//import java.util.List;
//
//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@Slf4j
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class InvoiceControllerTest {
//
//    @Autowired
//    private InvoiceRepository invoiceRepository;
//
//    @Test
//    @Order(1)
//    public void addInvoiceTestCase() {
//
//        Invoice invoice = new Invoice(Order, "2021-10-09T15:10:00.000", "User1");
//
//        invoice.setOrder("");
//        invoice.setGeneratedTimestamp("2021-10-09T15:10:00.000");
//        invoice.setGeneratedUser("User1");
//        assertNotNull(invoiceRepository.save(invoice));
//    }
//
//    @Test
//    @Order(2)
//    public void getAllInvoicesTestCase() {
//
//        List<Invoice> list = invoiceRepository.findAll();
//        assertThat(list).size().isGreaterThan(0);
//    }
//}
