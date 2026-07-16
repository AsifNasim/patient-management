package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import com.pm.patientservice.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

     public PatientController(PatientService patientService){
         this.patientService = patientService;
     }

     @GetMapping("/all")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatient(){
         List<PatientResponseDTO> patientResponseDTOS = patientService.getPatients();
         return ResponseEntity.ok().body(patientResponseDTOS);

     }

     @PostMapping("/create")
    public ResponseEntity<PatientResponseDTO> createPatient(@Validated({Default.class, CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequestDTOS){
         return ResponseEntity.ok().body(patientService.createPatient(patientRequestDTOS)) ;

     }

     @PutMapping("/update/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO){
         return  ResponseEntity.ok().body(patientService.updatePatient(id, patientRequestDTO));
     }
}
