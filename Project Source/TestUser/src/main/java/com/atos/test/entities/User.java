package com.atos.test.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/* Created By yassine */

@Entity
@Table(name = "USERS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    /**
     * User POJO
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Firstname may not be empty")
    private String firstname;
    @NotEmpty(message = "Lastname may not be empty")
    private String lastname;
    @NotNull
    @Min(18)
    private int age;
    @NotEmpty(message = "Country may not be empty")
    private String country;
    @NotEmpty(message = "Email may not be empty")
    @Email
    private String email;
    private String username = "userNameEmpty";
    private LocalDateTime creationDate;

}
