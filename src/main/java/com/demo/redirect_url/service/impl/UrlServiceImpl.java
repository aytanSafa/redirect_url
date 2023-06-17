package com.demo.redirect_url.service.impl;

import com.demo.redirect_url.dto.SaveUrlRequestDto;
import com.demo.redirect_url.entity.UrlEntity;
import com.demo.redirect_url.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UrlServiceImpl {

    private final UrlRepository urlRepository;
    private final ModelMapper modelMapper;

    public UrlEntity save(SaveUrlRequestDto saveUrlRequestDto) {

        if (urlRepository.findByShortCode(saveUrlRequestDto.getShortCode()).isPresent()){
            throw new RuntimeException("Short Code already Exist");
        }
        UrlEntity urlEntity = modelMapper.map(saveUrlRequestDto, UrlEntity.class);
        return  urlRepository.save(urlEntity);
    }

    public String findUrlByShortCode(String shortCode) {
        Optional<UrlEntity> urlEntityOptional = urlRepository.findByShortCode(shortCode);
        if (urlEntityOptional.isEmpty()){
            throw new RuntimeException("Short Code doesn't exist");
        }
        return urlEntityOptional.get().getRedirectUrl();
    }
    public void deleteByShortCode(String shortCode) {
        urlRepository.deleteByShortCode(shortCode);
    }


    public UrlEntity updateUrlEntity(UrlEntity urlEntity) {

        Optional<UrlEntity> oldUrlEntityOpt = urlRepository.findById(urlEntity.getId());

        UrlEntity oldUrlEntity = oldUrlEntityOpt.get();

        oldUrlEntity.setShortCode(urlEntity.getShortCode());
        oldUrlEntity.setRedirectUrl(urlEntity.getRedirectUrl());

        return urlRepository.save(oldUrlEntity);

    }
}
