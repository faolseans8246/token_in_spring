package org.example.create_token.controller;


import lombok.RequiredArgsConstructor;
import org.example.create_token.dto.UserDto;
import org.example.create_token.payload.ApiResponse;
import org.example.create_token.service.UserMongoService;
import org.example.create_token.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserMongoService userMongoService;

    @PostMapping("/savebase")
    public ResponseEntity<ApiResponse> saveUserNotes(@RequestBody UserDto userDto) {
        ApiResponse apiResponse = userService.saveUser(userDto);

        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
