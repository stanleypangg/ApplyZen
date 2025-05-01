package com.applyzen.applyzen.dto;

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
