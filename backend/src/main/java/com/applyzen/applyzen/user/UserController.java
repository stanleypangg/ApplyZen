package com.applyzen.applyzen.user;

import com.applyzen.applyzen.dto.user.UserDto;
import com.applyzen.applyzen.security.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final CurrentUserService currentUserService;

    @Autowired
    public UserController(UserService userService, CurrentUserService currentUserService) {
        this.userService = userService;
        this.currentUserService = currentUserService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> fetchUserProfile() {
        Long id = currentUserService.getCurrentUserId();
        UserDto userDto = userService.fetchUserProfile(id);
        return ResponseEntity.ok(userDto);
    }
}
