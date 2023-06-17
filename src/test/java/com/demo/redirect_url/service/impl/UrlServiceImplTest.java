package com.demo.redirect_url.service.impl;

import com.demo.redirect_url.entity.UrlEntity;
import com.demo.redirect_url.repository.UrlRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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




    @Test
    public void testSaveUrlEntity() {
        // Create a user entity
        UrlEntity urlEntity = new UrlEntity(1,"bit.ly","https://www.facebook.com/");

        // Mock the behavior of the repository's save method
        when(urlRepository.save(urlEntity)).thenReturn(urlEntity);

        // Call the save method on the service
        UrlEntity savedUser = urlService.save(urlEntity);

        // Verify that the repository's save method was called with the expected entity
        verify(urlService).save(urlEntity);

        // Perform assertions to verify the result
        assertNotNull(savedUser);

        assertEquals(urlEntity.getShortCode(),savedUser.getShortCode());
        assertEquals(urlEntity.getRedirectUrl(),savedUser.getRedirectUrl());
    }


}