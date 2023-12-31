package com.demo.redirect_url.service;

import com.demo.redirect_url.dto.SaveUrlRequestDto;
import com.demo.redirect_url.entity.UrlEntity;
import com.demo.redirect_url.repository.UrlRepository;
import com.demo.redirect_url.service.UrlService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UrlServiceTest {


    @MockBean
    UrlRepository urlRepository;
    @Autowired
    UrlService urlService;

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

    @Test
    void ifShortCodeIsExistThrowExceptionWhenSave(){
        SaveUrlRequestDto saveUrlRequestDto = new SaveUrlRequestDto("bit.ly","https://www.facebook.com/");

        UrlEntity urlEntity = modelMapper.map(saveUrlRequestDto,UrlEntity.class);

        urlService.save(saveUrlRequestDto);

        SaveUrlRequestDto saveUrlRequestDto2 = new SaveUrlRequestDto("bit.ly","https://www.facebook.com/");

        when(urlRepository.findByShortCode(saveUrlRequestDto2.getShortCode())).thenReturn(Optional.ofNullable(urlEntity));
        assertThrows(RuntimeException.class,() -> {
            throw new RuntimeException("Short Code already Exist");
        });
    }

    @Test
    void testFindUrlEntityIfExist(){

        UrlEntity urlEntity = new UrlEntity(1,"bit.ly","https://www.facebook.com/");

        when(urlRepository.findByShortCode("bit.ly")).thenReturn(Optional.of(urlEntity));

        String redirectUrl = urlService.findUrlByShortCode("bit.ly");

        assertEquals(urlEntity.getRedirectUrl(),redirectUrl);

    }

    @Test
    void testFindUrlEntityIfNotExist(){

        when(urlRepository.findByShortCode(anyString())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class,
                () -> urlService.findUrlByShortCode("bit.ly"));

    }

    @Test
    void testDeleteUrlEntity(){
        String shortCode = "bit.ly";

        doNothing().when(urlRepository).deleteByShortCode(shortCode);

        urlService.deleteByShortCode(shortCode);

        verify(urlRepository).deleteByShortCode(shortCode);
    }


    @Test
    void testUpdateUrlEntity(){

        UrlEntity updatedUrlEntity = new UrlEntity(1L,"bit.ly","https://www.facebook.com/");

        when(urlRepository.findById(updatedUrlEntity.getId())).thenReturn(Optional.of(updatedUrlEntity));
        when(urlRepository.save(updatedUrlEntity)).thenReturn(updatedUrlEntity);

        UrlEntity result = urlService.updateUrlEntity(updatedUrlEntity);

        assertNotNull(result);
        assertEquals(result.getId(), updatedUrlEntity.getId());
        assertEquals(result.getShortCode(), updatedUrlEntity.getShortCode());
        assertEquals(result.getRedirectUrl(), updatedUrlEntity.getRedirectUrl());
    }

    @Test
    void testUpdateUrlEntityIfDoesntExistEntity(){

        UrlEntity updatedUrlEntity = new UrlEntity(1L,"bit.ly","https://www.facebook.com/");

        when(urlRepository.findById(updatedUrlEntity.getId())).thenReturn(Optional.empty());
        when(urlRepository.save(updatedUrlEntity)).thenReturn(updatedUrlEntity);

        UrlEntity result = urlService.updateUrlEntity(updatedUrlEntity);

        assertNotNull(result);
        assertEquals(result.getId(), updatedUrlEntity.getId());
        assertEquals(result.getShortCode(), updatedUrlEntity.getShortCode());
        assertEquals(result.getRedirectUrl(), updatedUrlEntity.getRedirectUrl());
    }


}