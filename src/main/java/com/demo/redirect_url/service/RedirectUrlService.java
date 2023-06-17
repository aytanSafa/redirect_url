package com.demo.redirect_url.service;

import org.springframework.web.servlet.view.RedirectView;

public interface RedirectUrlService {
    RedirectView redirectUrl(String shortCode);
}
