package com.ufmg.fundep.service;

import com.ufmg.fundep.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private final List<Patient> patients;

    public PatientService() {
        patients = new ArrayList<>();
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public void createPatient(Patient patient) {
        patients.add(patient);
    }
}
