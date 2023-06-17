package com.demo.redirect_url.service;

import com.demo.redirect_url.service.RedirectUrlService;
import com.demo.redirect_url.service.UrlService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RedirectUrlServiceTest {


    @MockBean
    UrlService urlService;

    @Autowired
    RedirectUrlService redirecUrlService;

    @Test
    void redirectUrl() {

    }
}