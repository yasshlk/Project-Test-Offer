package com.atos.test.entities;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/* Created By yassine */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiErrors {

    String message;
    HttpStatus status;
    LocalDateTime timestamp;
}
