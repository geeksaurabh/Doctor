package com.example.Doctor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "doctor_tbl")
public class Doctor {
    @Id
    @Column(name = "doc_id")
   private Integer doctorId;
    @Column(name = "doc_name")
    private String doctorName;
    @Column(name = "doc_experience")
    private String doctorExperience;
    @Column(name = "doc_specialization")
    private String doctorSpecialization;
}
