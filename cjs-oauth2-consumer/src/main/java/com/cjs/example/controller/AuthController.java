package com.cjs.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ccq
 * @since 2021/1/26 13:45
 */
@RestController
public class AuthController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("login")
    public ResponseEntity<String> login(String code) {
        String redirectUri = "&redirect_uri=http://localhost:3000/login";
        String clientId = "&client_id=client";
        String secret = "&client_secret=123456";
        String grantType = "?grant_type=authorization_code";
        code = "&code=" + code;
        String url = "http://localhost:8080/oauth/token" + grantType + redirectUri + clientId + secret + code;
        String s = restTemplate.postForObject(url, null, String.class);
        return ResponseEntity.ok(s != null ? s : "");
    }
}
