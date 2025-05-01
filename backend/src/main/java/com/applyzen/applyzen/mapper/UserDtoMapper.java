package com.applyzen.applyzen.mapper;

import com.applyzen.applyzen.dto.user.UserDto;
import com.applyzen.applyzen.user.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDtoMapper implements Function<User, UserDto> {
    public UserDto apply(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getFirstName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
