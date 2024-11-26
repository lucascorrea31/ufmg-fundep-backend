package com.ufmg.fundep.resource;

import com.ufmg.fundep.model.Patient;
import com.ufmg.fundep.service.PatientService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/patients")
public class PatientResource {

    private final PatientService patientService = new PatientService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return Response.ok(patients).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPatient(Patient patient) {
        patientService.createPatient(patient);
        return Response.status(Response.Status.CREATED).build();
    }

    // TODO: Outros endpoints para atualizar e deletar pacientes
}
