package com.applyzen.applyzen.security;

import org.springframework.stereotype.Service;

@Service
public interface CurrentUserService {
    Long getCurrentUserId();
}
