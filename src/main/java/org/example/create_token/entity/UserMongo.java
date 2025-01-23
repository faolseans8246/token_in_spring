package org.example.create_token.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.create_token.roles.Gender;
import org.example.create_token.template.IdNotes;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usernotes")
public class UserMongo {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private int day;
    private String month;
    private int year;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
