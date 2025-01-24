package org.example.create_token.controller;

import lombok.RequiredArgsConstructor;
import org.example.create_token.dto.UserDto;
import org.example.create_token.payload.ApiResponse;
import org.example.create_token.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/savebase")
    public ResponseEntity<ApiResponse> saveUserNotes(@ModelAttribute UserDto userDto) {
        ApiResponse apiResponse = userService.saveUser(userDto);

        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
