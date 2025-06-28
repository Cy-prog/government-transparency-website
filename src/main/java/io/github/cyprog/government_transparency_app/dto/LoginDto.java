package io.github.cyprog.government_transparency_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

    @NotEmpty(message = "Email is required")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotEmpty(message = "Password is required")
    private String password;
}
