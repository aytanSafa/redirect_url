package com.demo.redirect_url.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaveUrlRequestDto {

    private String shortCode;
    private String redirectUrl;

}
