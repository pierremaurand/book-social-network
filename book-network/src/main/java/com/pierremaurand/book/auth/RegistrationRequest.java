package com.pierremaurand.book.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "Firstname is mandatary")
    @NotBlank(message = "Firstname is mandatary")
    private String firstname;
    @NotEmpty(message = "Lastname is mandatary")
    @NotBlank(message = "Lastname is mandatary")
    private String lastname;
    @Email(message = "Email is not formatted")
    @NotEmpty(message = "Email is mandatary")
    @NotBlank(message = "Email is mandatary")
    private String email;
    @NotEmpty(message = "Password is mandatary")
    @NotBlank(message = "Password is mandatary")
    @Size(min = 8, message = "Password should be 8 caracters long minimum")
    private String password;
}
