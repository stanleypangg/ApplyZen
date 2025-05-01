package com.applyzen.applyzen.user;

import com.applyzen.applyzen.dto.user.CreateUserDto;
import com.applyzen.applyzen.dto.user.UserDto;
import com.applyzen.applyzen.mapper.UserDtoMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDtoMapper userDtoMapper;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDtoMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDtoMapper = userDtoMapper;
    }

    @Transactional
    public UserDto register(CreateUserDto createUserDto) {
        // Validate email uniqueness
        if (userRepository.existsByEmail(createUserDto.email())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email is already registered"
            );
        }

        // Hash password
        String hash = passwordEncoder.encode(createUserDto.password());

        // Create and save user
        User newUser = new User(createUserDto.email(), hash);
        newUser.setFirstName(createUserDto.firstName());
        newUser.setLastName(createUserDto.lastName());
        userRepository.save(newUser);

        // TODO: Seed default statuses

        // Map to DTO
        return userDtoMapper.apply(newUser);
    }
}
