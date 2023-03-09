package com.example.Doctor.controller;

import com.example.Doctor.model.Doctor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;
import com.example.Doctor.controller.Patient;

import java.security.Timestamp;

@RestController
public class PatientController {
    private Patient setPatient(JSONObject json) {

        Patient patient = new Patient();

        patient.setPatientId(json.getInt("patientId"));
        patient.setPatientName(json.getString("patientName"));
        patient.setAge(json.getInt("age"));
        patient.setPhoneNumber(json.getString("phoneNumber"));
        patient.setDiseaseType(json.getString("diseaseType"));
        patient.setGender(json.getString("gender"));

        Timestamp currTime = new Timestamp(System.currentTimeMillis());
        patient.setAdmitDate(currTime);

        String doctorId = json.getString("doctorId");
        Doctor doctor = doctorRepository.getDoctorById(doctorId);
        patient.setDoctorId(doctor);

        return patient;


    }



}
