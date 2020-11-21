package com.pinta.clinichistory.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.pinta.clinichistory.model.Patient;

public interface PatientService {
	
	Patient createPatient(Patient patient);
	
	Patient findPatientById(Long id) throws EntityNotFoundException;
	
	void deletePatientById(Long id) throws EntityNotFoundException;
	
	void deletePatient(Patient patient) throws EntityNotFoundException;
	
	void updatePatient(Patient patient);
	
	List<Patient> findAllPatients();
	
	List<Patient> findAllPatientsByTreatmentId(Long treatmentId);
}
