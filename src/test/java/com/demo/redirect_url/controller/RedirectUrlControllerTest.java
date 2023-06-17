package com.demo.redirect_url.controller;

import com.demo.redirect_url.dto.AuthenticationResponse;
import com.demo.redirect_url.dto.RegisterRequest;
import com.demo.redirect_url.filter.JwtAuthenticationFilter;
import com.demo.redirect_url.repository.UrlRepository;
import com.demo.redirect_url.service.AuthenticationService;
import com.demo.redirect_url.service.JwtService;
import com.demo.redirect_url.service.RedirectUrlService;
import com.demo.redirect_url.service.UrlService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.view.RedirectView;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @MockBean
    JwtAuthenticationFilter filter;

    @MockBean
    AuthenticationService authenticationService;

    @Test
    public void testRedirectView() throws Exception {

    }
    

}