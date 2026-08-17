package com.pm.authservice.dto;

import jakarta.validation.constraints.*;

public class LoginRequestDTO {

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "password is required")
    @NotNull
    @Size(min = 3, max = 12, message = "Password should be between 8 to 12 characters")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
