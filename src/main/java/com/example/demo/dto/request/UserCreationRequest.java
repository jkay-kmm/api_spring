package com.example.demo.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class UserCreationRequest {
    @Size(min = 2, max = 50, message = "USERNAME_INVALID")
    private String name;

    @Size(min = 8, max = 20, message = "INVALID_PASSWORD")
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
