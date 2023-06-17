package com.demo.redirect_url.service.impl;

import com.demo.redirect_url.dto.SaveUrlRequestDto;
import com.demo.redirect_url.entity.UrlEntity;
import com.demo.redirect_url.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UrlServiceImpl {

    private final UrlRepository urlRepository;
    private final ModelMapper modelMapper;

    public UrlEntity save(SaveUrlRequestDto saveUrlRequestDto) {
        UrlEntity urlEntity = modelMapper.map(saveUrlRequestDto, UrlEntity.class);
        return  urlRepository.save(urlEntity);
    }
}
