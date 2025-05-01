package com.applyzen.applyzen.dto.user;

import java.time.LocalDateTime;

public record UserDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){

}
