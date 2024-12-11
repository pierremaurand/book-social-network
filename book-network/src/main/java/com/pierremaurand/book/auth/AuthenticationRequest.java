package com.pierremaurand.book.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationRequest {

    @Email(message = "Email is not formatted")
    @NotEmpty(message = "Email is mandatary")
    @NotBlank(message = "Email is mandatary")
    private String email;

    @NotEmpty(message = "Password is mandatary")
    @NotBlank(message = "Password is mandatary")
    @Size(min = 8, message = "Password should be 8 caracters long minimum")
    private String password;
}
