package com.cjs.example.service;

import com.cjs.example.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ccq
 * @since 2021/1/22 17:07
 */
@FeignClient(value = "user-service", url = "localhost:8090")
public interface UserService {

    @GetMapping("/user")
    User getUser();
}
