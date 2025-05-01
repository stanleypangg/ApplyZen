package com.applyzen.applyzen.dto.user;

import org.springframework.lang.Nullable;

public record CreateUserDto (
        String email,
        String password,

        @Nullable String firstName,
        @Nullable String lastName
) {

}
