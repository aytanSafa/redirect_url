package com.demo.redirect_url.service.impl;

import com.demo.redirect_url.dto.SaveUrlRequestDto;
import com.demo.redirect_url.entity.UrlEntity;
import com.demo.redirect_url.repository.UrlRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UrlServiceImplTest {


    @MockBean
    UrlRepository urlRepository;
    @Autowired
    UrlServiceImpl urlService;

    @Autowired
    ModelMapper modelMapper;




    @Test
    void testSaveUrlEntity() {

        SaveUrlRequestDto saveUrlRequestDto = new SaveUrlRequestDto("bit.ly","https://www.facebook.com/");

        UrlEntity urlEntity = modelMapper.map(saveUrlRequestDto,UrlEntity.class);

        when(urlRepository.save(urlEntity)).thenReturn(urlEntity);

        UrlEntity savedUser = urlService.save(saveUrlRequestDto);

        verify(urlRepository).save(urlEntity);

        assertNotNull(savedUser);

        assertEquals(urlEntity.getShortCode(),savedUser.getShortCode());
        assertEquals(urlEntity.getRedirectUrl(),savedUser.getRedirectUrl());
    }

  /*  @Test
    void ifShortCodeIsExistWhenSave(){
        SaveUrlRequestDto saveUrlRequestDto = new SaveUrlRequestDto("bit.ly","https://www.facebook.com/");

        UrlEntity urlEntity = modelMapper.map(saveUrlRequestDto,UrlEntity.class);
        UrlEntity savedUser = urlService.save(saveUrlRequestDto);

        SaveUrlRequestDto saveUrlRequestDto2 = new SaveUrlRequestDto("bit.ly","https://www.facebook.com/");


    }
*/

}