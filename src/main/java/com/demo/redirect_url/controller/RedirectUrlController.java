package com.demo.redirect_url.controller;

import com.demo.redirect_url.service.RedirectUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("api/v1/redirect")
@RequiredArgsConstructor
public class RedirectUrlController {

    private final RedirectUrlService redirectUrlService;
    @GetMapping(value = "/{shortCode}")
    public RedirectView redirectView(@PathVariable String shortCode){
        return redirectUrlService.redirectUrl(shortCode);
    }

}
