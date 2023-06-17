package com.demo.redirect_url.repository;

import com.demo.redirect_url.entity.UrlEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(properties = {
        "spring.jpa.show-sql=false",
        "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect",
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
 class UrlRepositoryTest {

    @Autowired
    UrlRepository urlRepository;


    @DisplayName("Find Url by ShortCode")
    @Test
    void testFindUrlEntityByShortCode(){

        UrlEntity urlEntity = new UrlEntity(1,"bit.ly","https://www.facebook.com/");

        urlRepository.save(urlEntity);

        Optional<UrlEntity> retrievedUrlEntity = urlRepository.findByShortCode("bit.ly");

        assertTrue(retrievedUrlEntity.isPresent());

        assertEquals(urlEntity.getShortCode(),retrievedUrlEntity.get().getShortCode());
        assertEquals(urlEntity.getRedirectUrl(),retrievedUrlEntity.get().getRedirectUrl());


    }

    @DisplayName("Save")
    @Test
     void testSaveUrlEntity(){

        UrlEntity urlEntity = new UrlEntity(1,"bit.ly","https://www.facebook.com/");

        UrlEntity savedUrlEntity = urlRepository.save(urlEntity);

        Optional<UrlEntity> retrievedUrlEntity = urlRepository.findById(savedUrlEntity.getId());

        assertTrue(retrievedUrlEntity.isPresent());

        assertEquals(urlEntity.getShortCode(),retrievedUrlEntity.get().getShortCode());
        assertEquals(urlEntity.getRedirectUrl(),retrievedUrlEntity.get().getRedirectUrl());
    }
    @DisplayName("Delete")
    @Test
     void testDeleteUrlEntity (){
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setShortCode("bit.ly");
        urlEntity.setRedirectUrl("https://www.facebook.com/");
        urlRepository.save(urlEntity);
        urlRepository.delete(urlEntity);
        assertFalse(urlRepository.findById(1L).isPresent());
    }

    @DisplayName("Update")
    @Test
     void testUpdateUrlEntity(){
        UrlEntity urlEntity = new UrlEntity(1,"bit.ly","https://www.facebook.com/");
        urlRepository.save(urlEntity);

        urlEntity.setShortCode("t.co");
        urlEntity.setRedirectUrl("https://twitter.com/");
        UrlEntity updatedUrlEntity = urlRepository.save(urlEntity);

        assertEquals("t.co", updatedUrlEntity.getShortCode());
        assertEquals("https://twitter.com/", updatedUrlEntity.getRedirectUrl());


    }

}
