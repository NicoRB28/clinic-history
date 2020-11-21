package com.pinta.clinichistory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinta.clinichistory.model.Patient;
import com.pinta.clinichistory.service.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	@GetMapping("/patient")
	public List<Patient> getPatientByTreatmentId(){
		return this.patientService.findAllPatientsByTreatmentId(Long.valueOf(1));
	}
	
}
