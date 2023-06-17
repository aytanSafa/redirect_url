package com.demo.redirect_url.controller;

import com.demo.redirect_url.repository.UrlRepository;
import com.demo.redirect_url.service.RedirectUrlService;
import com.demo.redirect_url.service.UrlService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.view.RedirectView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RedirectUrlController.class)
@ExtendWith(SpringExtension.class)
class RedirectUrlControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RedirectUrlService redirectUrlService;

    @MockBean
    UrlService urlService;

    @MockBean
    UrlRepository urlRepository;

    @Test
    public void testRedirectView() throws Exception {

        mockMvc.perform(get("/api/v1/redirect/t.co"))
                .andExpect(status().is2xxSuccessful());
    }
    

}