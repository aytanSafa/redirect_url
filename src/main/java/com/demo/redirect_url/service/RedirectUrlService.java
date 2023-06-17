package com.demo.redirect_url.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
@RequiredArgsConstructor
public class RedirectUrlService implements RedirectUrlService {

    private final UrlService urlService;


    @Override
    public RedirectView redirectUrl(String shortCode) {
        return null;
    }
}
