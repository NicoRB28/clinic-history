package com.pinta.clinichistory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pinta.clinichistory.dto.PatientDTO;
import com.pinta.clinichistory.mapper.PatientMapper;
import com.pinta.clinichistory.model.Diagnosis;
import com.pinta.clinichistory.model.Patient;
import com.pinta.clinichistory.model.Reason;
import com.pinta.clinichistory.model.Treatment;
import com.pinta.clinichistory.service.DiagnosisService;
import com.pinta.clinichistory.service.PatientService;
import com.pinta.clinichistory.service.ReasonService;
import com.pinta.clinichistory.service.TreatmentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DiagnosisService diagnosisService;
	
	@Autowired
	private ReasonService reasonService;
	
	@Autowired
	private TreatmentService treatmentService;
	
	@PostMapping("/patient/create")
	public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO){
		Patient newPatient = PatientMapper.patientDtoToPatient(patientDTO);
		Patient patientDb = patientService.createPatient(newPatient);
		return new ResponseEntity<PatientDTO>(patientDTO,HttpStatus.CREATED);
	}
	
	//TODO: estos endpoints son provisorios y a los fines de testear determinados
	//		metodos
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return this.patientService.findAllPatients();
	}
	
	@GetMapping("/patient")
	public List<Patient> getPatientByTreatmentId(){
		return this.patientService.findAllPatientsByTreatmentId(Long.valueOf(1));
	}
	
	@GetMapping("/patientsByDiagnosisId")
	public List<Patient> getPatientByDiagnosisId(){
		return this.patientService.findAllPatientsByDiagnosisId(Long.valueOf(1));
	}
	
	@PutMapping("/patient/{patientId}/{reasonId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void addReasonToPatient(@PathVariable(name = "patientId")Long patientId, @PathVariable(name = "reasonId")Long reasonId) {
		Patient patientInDb = patientService.findPatientById(patientId);
		Reason reasonInDb = reasonService.findReasonById(reasonId);
		patientInDb.addReason(reasonInDb);
		patientService.updatePatient(patientInDb);
		
	}
	
	@PutMapping("/patient/{patientId}/diagnosis/{diagnosisId}")
	@ResponseStatus(value = HttpStatus.OK )
	public void addDiagnosisToPatient(@PathVariable(name = "patientId")Long patientId, @PathVariable(name = "diagnosisId")Long diagnosisId) {
		Patient patientInDb = patientService.findPatientById(patientId);
		Diagnosis diagnosisInDb = diagnosisService.findDiagnosisById(diagnosisId);
		patientInDb.addDiagnosis(diagnosisInDb);
		
		patientService.updatePatient(patientInDb);
	}
	
	@PutMapping("/patient/{patientId}/treatment/{treatmentId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void addTreatmentToPatient(@PathVariable(name = "patientId")Long patientId, @PathVariable(name="treatmentId")Long treatmentId) {
		Patient patientInDb = patientService.findPatientById(patientId);
		Treatment treatmentInDb = treatmentService.findTreatmentById(treatmentId);
		patientInDb.addTreatment(treatmentInDb);
		
		patientService.updatePatient(patientInDb);
	}
}
