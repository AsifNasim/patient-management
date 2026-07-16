package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "https://editor.swagger.io/")
@RestController
@RequestMapping("/api/patients")
@Tag(name="Patient", description = "List of APIs for managing patients")
public class PatientController {

     private final PatientService patientService;

     public PatientController(PatientService patientService){
         this.patientService = patientService;
     }

     @GetMapping("/all")
     @Operation(summary = "Get Patients")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatient(){
         List<PatientResponseDTO> patientResponseDTOS = patientService.getPatients();
         return ResponseEntity.ok().body(patientResponseDTOS);

     }

     @PostMapping("/create")
     @Operation(summary = "Create Patient")
    public ResponseEntity<PatientResponseDTO> createPatient(@Validated({Default.class, CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequestDTOS){
         return ResponseEntity.ok().body(patientService.createPatient(patientRequestDTOS)) ;

     }

     @PutMapping("/update/{id}")
     @Operation(summary = "Update Patient")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO){
         return  ResponseEntity.ok().body(patientService.updatePatient(id, patientRequestDTO));
     }

     @DeleteMapping("/delete/{id}")
     @Operation(summary = "Delete a Patient")
    public ResponseEntity<PatientResponseDTO> deletePatient(@PathVariable UUID id){
         return ResponseEntity.ok().body(patientService.deletePatient(id));
     }

}
