package com.demo.redirect_url.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
@RequiredArgsConstructor
public class RedirectUrlService{

    private final UrlService urlService;

    public RedirectView redirectUrl(String shortCode) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(urlService.findUrlByShortCode(shortCode));
        return redirectView;
    }
}
