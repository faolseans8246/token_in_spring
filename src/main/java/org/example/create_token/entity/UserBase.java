package org.example.create_token.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.create_token.roles.Gender;
import org.example.create_token.template.IdNotes;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usernotes")
public class UserBase extends IdNotes {

    private String firstname;
    private String lastname;
    private int day;
    private String month;
    private int year;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
