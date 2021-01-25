package com.cjs.example.service.impl;

import com.cjs.example.entity.User;
import com.cjs.example.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author ccq
 * @since 2021/1/22 17:45
 */
@Component
public class UserServiceFallback implements UserService {
    @Override
    public User getUser() {
        return new User();
    }
}
