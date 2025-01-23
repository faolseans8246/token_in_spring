package org.example.create_token.controller;


import lombok.RequiredArgsConstructor;
import org.example.create_token.dto.UserDto;
import org.example.create_token.payload.ApiResponse;
import org.example.create_token.service.UserMongoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usermongo")
public class UserMongoController {

    private final UserMongoService userMongoService;

    @PostMapping("/savemongo")
    public ResponseEntity<ApiResponse> saveMongoUser(@RequestBody UserDto userDto) {
        ApiResponse apiResponse = userMongoService.userMongoSave(userDto);

        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }
}
