package com.pm.patientservice.dto;

import com.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class PatientRequestDTO {


    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceeds 100 characters")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "Email should be a valid one")
    private String email;

    @NotBlank(message = "Address should be valid")
    private String address;

    @NotBlank(message = "Date of Birth should be a valid one")
    private String dateOfBirth;

    @NotBlank(groups = CreatePatientValidationGroup.class, message = "registered Date should be a valid one")
    private String registeredDate;

    public @NotBlank(message = "Name is required") @Size(max = 100, message = "Name cannot exceeds 100 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") @Size(max = 100, message = "Name cannot exceeds 100 characters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "email is required") @Email(message = "Email should be a valid one") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "email is required") @Email(message = "Email should be a valid one") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Address should be valid") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Address should be valid") String address) {
        this.address = address;
    }

    public @NotBlank(message = "Date of Birth should be a valid one") String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotBlank(message = "Date of Birth should be a valid one") String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate( String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
