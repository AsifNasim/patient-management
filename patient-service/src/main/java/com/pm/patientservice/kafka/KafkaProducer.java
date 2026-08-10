package com.pm.patientservice.kafka;

import com.pm.patientservice.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;


@Service
public class KafkaProducer {


    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    //     This is how we define message and then sent using kafka template
    private final KafkaTemplate<String, byte []> kafkaTemplate;

//    constructor initialization
    public KafkaProducer(KafkaTemplate<String, byte []> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }



    public void sendEvent(Patient patient){
        PatientEvent event = PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
//                creating a category further in kafka
                .setEventType("PATIENT CREATED")
                .build();

        log.info("Patient created : {}", event);

        try {
            kafkaTemplate.send("patient", event.toByteArray());
        } catch (Exception e) {
            log.error("Error in sending Patient Created Event {}", event);
        }
    }



}
