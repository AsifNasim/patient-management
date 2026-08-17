package com.pm.authservice.dto;


public class LoginResponseDTO {


    private final String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }


//    serialize the token inti json
    public String getToken(){
        return token;
    }
}
