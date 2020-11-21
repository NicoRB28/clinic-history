package com.pinta.clinichistory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinta.clinichistory.dto.PatientDTO;
import com.pinta.clinichistory.mapper.PatientMapper;
import com.pinta.clinichistory.model.Patient;
import com.pinta.clinichistory.service.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/patient/create")
	public ResponseEntity<Patient> createPatient(@RequestBody PatientDTO patientDTO){
		Patient newPatient = PatientMapper.patientDtoToPatient(patientDTO);
		Patient patientDb = patientService.createPatient(newPatient);
		return new ResponseEntity<Patient>(patientDb,HttpStatus.CREATED);
	}
	
	//TODO: estos endpoints son provisorios y a los fines de testear determinados
	//		metodos
	
	@GetMapping("/patient")
	public List<Patient> getPatientByTreatmentId(){
		return this.patientService.findAllPatientsByTreatmentId(Long.valueOf(1));
	}
	
	@GetMapping("/patientsByDiagnosisId")
	public List<Patient> getPatientByDiagnosisId(){
		return this.patientService.findAllPatientsByDiagnosisId(Long.valueOf(1));
	}
}
