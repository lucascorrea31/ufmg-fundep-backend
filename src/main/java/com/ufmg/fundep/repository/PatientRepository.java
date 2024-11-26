package com.ufmg.fundep.repository;

import com.ufmg.fundep.model.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    private final Connection connection;

    public PatientRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Patient> findAll() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setAge(rs.getInt("age"));
                patient.setEmail(rs.getString("email"));
                patient.setHospitalId(rs.getObject("hospital_id", Integer.class));
                patients.add(patient);
            }
        }
        return patients;
    }

    // TODO: Metodos adicionais para CRUD
}
