package com.applyzen.applyzen.security;

public class StubCurrentUserService implements CurrentUserService {

    @Override
    public Long getCurrentUserId() {
        return 1L;
    }
}
