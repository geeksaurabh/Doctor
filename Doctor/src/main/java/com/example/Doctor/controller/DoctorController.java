package com.example.Doctor.controller;

import com.example.Doctor.model.Doctor;
import com.example.Doctor.service.DoctorService;
import jakarta.websocket.server.PathParam;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    DoctorService service;
    @PostMapping(value = "/doctor")
    public ResponseEntity<String> saveDoctor(@RequestBody String requestDoctor) {

        JSONObject json = new JSONObject(requestDoctor);

        List<String> validationList = validateDoctor(json);

        if(validationList.isEmpty()) {
            Doctor doctor = setDoctor(json);
            service.saveDoctor(doctor);
            return new ResponseEntity<>("Doctor saved", HttpStatus.CREATED);
        } else {

            String[] answer = Arrays.copyOf(
                    validationList.toArray(), validationList.size(), String[].class);

            return new ResponseEntity<>("Please pass these mandatory parameters- " +
                    Arrays.toString(answer), HttpStatus.BAD_REQUEST);
        }

    }




    @GetMapping(value = "find-all-doctor")
    public List<Doctor> getDoctor(){
        return service.getDoctor();

    }
    @GetMapping(value = "/get-by-id/{id}")
    public Doctor getDoctorById(@RequestParam int doctorId){
        return service.getDoctorById(doctorId);
    }

    private List<String> validateDoctor(JSONObject json) {

        List<String> errorList = new ArrayList<>();

        if(!json.has("doctorId")) {
            errorList.add("doctorId");
        }

        if(!json.has("doctorName")) {
            errorList.add("doctorName");
        }

        if(!json.has("specializedIn")) {
            errorList.add("specializedIn");
        }

        return errorList;

    }


    public Doctor setDoctor (JSONObject json) {
        Doctor doctor = new Doctor();

        String doctorId =  json.getString("doctorId");
        doctor.setDoctorId(Integer.valueOf(doctorId));

        String doctorName = json.getString("doctorName");
        doctor.setDoctorName(doctorName);

        String specializedIn = json.getString("specializedIn");
        doctor.setDoctorSpecialization(specializedIn);

        if(json.has("experience")) {
            String exp = json.getString("experience");
            doctor.setDoctorExperience(exp);
        }

        return doctor;

    }


}
