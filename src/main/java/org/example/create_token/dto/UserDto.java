package org.example.create_token.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
