package com.demo.redirect_url.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthenticationResponse {

    private String token;

}
