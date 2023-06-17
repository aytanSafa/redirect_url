package com.demo.redirect_url.service;

import org.springframework.web.servlet.view.RedirectView;

public interface UrlService {
    RedirectView redirectUrl(String shortCode);
}
