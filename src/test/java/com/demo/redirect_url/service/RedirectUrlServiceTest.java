package com.demo.redirect_url.service;

import com.demo.redirect_url.dto.SaveUrlRequestDto;
import com.demo.redirect_url.entity.UrlEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.view.RedirectView;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RedirectUrlServiceTest {


    @MockBean
    UrlService urlService;

    @Autowired
    RedirectUrlService redirecUrlService;

    @Autowired
    ModelMapper modelMapper;

    @Test
    void redirectUrl() {

        UrlEntity urlEntity = new UrlEntity(1,"bit.ly","https://www.facebook.com/");

        SaveUrlRequestDto saveUrlRequestDto = modelMapper.map(urlEntity, SaveUrlRequestDto.class);

        when(urlService.save(saveUrlRequestDto)).thenReturn(urlEntity);
        when(urlService.findUrlByShortCode(urlEntity.getShortCode())).thenReturn(urlEntity.getRedirectUrl());
        RedirectView redirectView = redirecUrlService.redirectUrl(urlEntity.getShortCode());
        Assertions.assertEquals(urlEntity.getRedirectUrl(),redirectView.getUrl());


    }
}