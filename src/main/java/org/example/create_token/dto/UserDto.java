package org.example.create_token.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.create_token.roles.Gender;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String firstname;
    private String lastname;
    private int day;
    private String month;
    private int year;

    private Gender gender;
}
