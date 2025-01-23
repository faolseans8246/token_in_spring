package org.example.create_token.service;

import lombok.RequiredArgsConstructor;
import org.example.create_token.dto.UserDto;
import org.example.create_token.entity.UserMongo;
import org.example.create_token.jwt.JwtTokenProvider;
import org.example.create_token.payload.ApiResponse;
import org.example.create_token.repository.mongo.UserMongoRepos;
import org.example.create_token.roles.Gender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMongoService {

    @Qualifier("mongoUserRepo")
    private final UserMongoRepos mongoUserRepos;
    private final JwtTokenProvider jwtTokenProvider;

    // Saved to MongoDB
    public ApiResponse userMongoSave(UserDto userDto) {
        UserMongo userMongo = new UserMongo();
        userMongo.setFirstname(userDto.getFirstname());
        userMongo.setLastname(userDto.getLastname());
        userMongo.setDay(userDto.getDay());
        userMongo.setMonth(userDto.getMonth());
        userMongo.setYear(userDto.getYear());
        userMongo.setGender(userDto.getGender() == null ? Gender.OTHER : userDto.getGender());

        mongoUserRepos.save(userMongo);

        String token = jwtTokenProvider.generateToken(userDto.getFirstname() + "_"  + userDto.getLastname());
        return new ApiResponse("Saved to mongo base", true, token);
    }
}
