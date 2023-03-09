package com.example.Doctor.service;

import com.example.Doctor.Dao.DoctorRepository;
import com.example.Doctor.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Doctor.model.Doctor;

import javax.print.Doc;
import java.util.List;

@Service

public class DoctorService {
    @Autowired
    DoctorRepository repository;
    public Doctor saveDoctor(Doctor doctor){
        return repository.save(doctor);
    }
    public List<Doctor> getDoctor(){
        return repository.findAll();
    }

    public Doctor getDoctorById( int doctorId) {
        return repository.findById( doctorId).get();
    }
}
