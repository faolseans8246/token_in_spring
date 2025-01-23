package org.example.create_token.service;

import lombok.RequiredArgsConstructor;
import org.example.create_token.dto.UserDto;
import org.example.create_token.entity.UserBase;
import org.example.create_token.payload.ApiResponse;
import org.example.create_token.repository.jpa.UserRepos;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Qualifier("jpaUserRepo")
    private final UserRepos jpaUserRepos;


    // Ma'lumotlar saqlandi
    public ApiResponse saveUser(UserDto userDto) {
        UserBase user = new UserBase();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setDay(userDto.getDay());
        user.setMonth(userDto.getMonth());
        user.setYear(userDto.getYear());

        jpaUserRepos.save(user);

        return new ApiResponse("Notes saves successfully", true);
    }
}
