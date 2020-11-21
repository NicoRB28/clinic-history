package com.pinta.clinichistory.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinta.clinichistory.model.Patient;
import com.pinta.clinichistory.repository.PatientRepository;
import com.pinta.clinichistory.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Patient createPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient findPatientById(Long id) throws EntityNotFoundException {
		return patientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public void deletePatientById(Long id) throws EntityNotFoundException {
		patientRepository.deleteById(id);
	}

	@Override
	public void deletePatient(Patient patient) throws EntityNotFoundException {
		patientRepository.delete(patient);
	}

	@Override
	public void updatePatient(Patient patient) {
		Patient patientInDb = this.findPatientById(patient.getId());
		patientInDb.setDni(patient.getDni());
		patientInDb.setLastName(patient.getLastName());
		patientInDb.setName(patient.getName());
		patientInDb.setReasons(patient.getReasons());
		patientInDb.setTreatments(patient.getTreatments());
		this.patientRepository.save(patientInDb);
	}

	@Override
	public List<Patient> findAllPatients() {
		return StreamSupport.stream(patientRepository
									.findAll()
									.spliterator(), false)
									.collect(Collectors.toList());
	}

	@Override
	public List<Patient> findAllPatientsByTreatmentId(Long treatmentId) {
		return this.patientRepository.findByTreatmentId(treatmentId);
	}

	@Override
	public List<Patient> findAllPatientsByDiagnosisId(Long diagnosisId) {
		return this.patientRepository.findByDiagnosisId(diagnosisId);
	}

}
