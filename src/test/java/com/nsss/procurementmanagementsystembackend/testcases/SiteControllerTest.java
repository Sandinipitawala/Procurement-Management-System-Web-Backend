package com.nsss.procurementmanagementsystembackend.testcases;//package com.nsss.procurementmanagementsystembackend.testcases;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.nsss.procurementmanagementsystembackend.model.Order;
//import com.nsss.procurementmanagementsystembackend.model.Site;
//import com.nsss.procurementmanagementsystembackend.repository.InvoiceRepository;
//import com.nsss.procurementmanagementsystembackend.repository.SiteRepository;
//import com.nsss.procurementmanagementsystembackend.request.OrderRequest;
//import lombok.Builder;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.time.ZonedDateTime;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.not;
//import static org.hamcrest.Matchers.notNullValue;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest
//public class SiteControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @MockBean
//    SiteRepository siteRepository;
//
//    @MockBean
//    InvoiceRepository invoiceRepository;
//
//    Site SITE_1 = new Site("Site A", "143/2 Flower Road, Kandy",
//            "Kandy", "0774444444", "available");
//    Site SITE_2 = new Site( "Site B",
//            "154/2/A Dam Street, Pettah", "Pettah", "0771111111", "unavailable");
//    Site SITE_3 = new Site( "Site C",
//            "212/B Baker Street, London", "London", "0772222222", "available");
//
//    @Disabled
//    @Test
//    public void getAllSitesTestCase() throws Exception {
//        List<Site> sites = new ArrayList<>(Arrays.asList(SITE_1, SITE_2, SITE_3));
//
//        Mockito.when(siteRepository.findAll()).thenReturn(sites);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/access/sites")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(3)))
//                .andExpect(jsonPath("$[1].name", is("Site B")))
//                .andExpect(jsonPath("$[2].name", not("Site A")))
//                .andExpect(jsonPath("$[1].mobile", is("0771111111")))
//                .andExpect(jsonPath("$[2].mobile", not("0772222221")))
//                .andExpect(jsonPath("$[1].status", is("unavailable")))
//                .andExpect(jsonPath("$[2].status", not("unavailable")));
//    }
//
//    @Test
//    public void addSiteTestCase() throws Exception {
//        Site site = Site.builder()
//                .name("Site A")
//                .address("143/2 Flower Road, Kandy")
//                .city("Kandy")
//                .mobile("0774444444")
//                .status("available")
//                .build();
//
//        Mockito.when(siteRepository.save(site)).thenReturn(site);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/access/sites")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.objectMapper.writeValueAsString(site));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$.name", is("Site A")))
//                .andExpect(jsonPath("$.name", not("Site B")))
//                .andExpect(jsonPath("$.mobile", is("0774444444")))
//                .andExpect(jsonPath("$.mobile", not("0774444445")))
//                .andExpect(jsonPath("$.status", is("available")))
//                .andExpect(jsonPath("$.status", not("unavailable")));
//    }
//}

import com.nsss.procurementmanagementsystembackend.model.Site;
import com.nsss.procurementmanagementsystembackend.repository.SiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SiteControllerTest {

    @Autowired
    private SiteRepository siteRepository;

    @Test
    @Order(1)
    public void addSiteTestCase() {

        Site site = new Site("Site A", "143/2 Flower Road, Kandy", "Kandy", "0774444444", "available");

        site.setName("Site A");
        site.setAddress("Temple rd");
        site.setCity("Kandy");
        site.setMobile("0712456656");
        site.setStatus("available");
        assertNotNull(siteRepository.save(site));
    }

    @Test
    @Order(2)
    public void getAllSitesTestCase () {

        List<Site> list = siteRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }
}