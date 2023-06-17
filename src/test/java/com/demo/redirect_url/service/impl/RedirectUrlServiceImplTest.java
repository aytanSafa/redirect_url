package com.demo.redirect_url.service.impl;

import com.demo.redirect_url.entity.RedirectEntity;
import com.demo.redirect_url.repository.RedirectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;

class RedirectUrlServiceImplTest {


    @MockBean
    RedirectRepository redirectRepository;

    @Test
    public void isShortCodeExist(){

        RedirectEntity redirectEntity = new RedirectEntity(1,"bit.ly","https://www.facebook.com/");

        when(redirectRepository.findByShortCode("bit.ly")).thenReturn(Optional.of(redirectEntity));


    }


}