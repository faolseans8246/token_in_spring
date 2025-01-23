package org.example.create_token.service;

import lombok.RequiredArgsConstructor;
import org.example.create_token.dto.UserDto;
import org.example.create_token.entity.UserBase;
import org.example.create_token.jwt.JwtTokenProvider;
import org.example.create_token.payload.ApiResponse;
import org.example.create_token.repository.jpa.UserRepos;
import org.example.create_token.roles.Gender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Qualifier("jpaUserRepo")
    private final UserRepos jpaUserRepos;
    private final JwtTokenProvider jwtTokenProvider;


    // Ma'lumotlar saqlandi
    public ApiResponse saveUser(UserDto userDto) {
        UserBase user = new UserBase();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setDay(userDto.getDay());
        user.setMonth(userDto.getMonth());
        user.setYear(userDto.getYear());

        if (userDto.getGender() != null) {
            user.setGender(userDto.getGender());
        } else {
            user.setGender(Gender.OTHER);
        }

        jpaUserRepos.save(user);
        String token = jwtTokenProvider.generateToken(userDto.getFirstname() + "_" + userDto.getLastname());

        return new ApiResponse("Notes saves successfully", true, token);
    }
}
