package com.pinta.clinichistory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinta.clinichistory.dto.DiagnosisDTO;
import com.pinta.clinichistory.model.Diagnosis;
import com.pinta.clinichistory.service.DiagnosisService;

@RestController
@RequestMapping("/api/diagnosis")
@CrossOrigin(origins = "*")
public class DiagnosisController {
	
	@Autowired
	private DiagnosisService diagnosisService;
	
	@PostMapping("/create")
	public ResponseEntity<DiagnosisDTO> createDiagnosis(@RequestBody DiagnosisDTO request){
		Diagnosis newDiagnosis = new Diagnosis(request);
		this.diagnosisService.createDiagnosis(newDiagnosis);
		return new ResponseEntity<DiagnosisDTO>(new DiagnosisDTO(newDiagnosis), HttpStatus.OK);
	}
}
