package com.pinta.clinichistory.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.pinta.clinichistory.dto.DiagnosisDTO;
import com.pinta.clinichistory.model.Diagnosis;
import com.pinta.clinichistory.model.Illness;
import com.pinta.clinichistory.service.DiagnosisService;
import com.pinta.clinichistory.service.IllnessService;

@RestController
@RequestMapping("/api/diagnosis")
@CrossOrigin(origins = "*")
public class DiagnosisController {
	
	@Autowired
	private DiagnosisService diagnosisService;
	
	@Autowired
	private IllnessService IllnessService;
	
	@PostMapping("/create")
	public ResponseEntity<DiagnosisDTO> createDiagnosis(@RequestBody DiagnosisDTO request){
		Diagnosis newDiagnosis = new Diagnosis(request);
		this.diagnosisService.createDiagnosis(newDiagnosis);
		return new ResponseEntity<DiagnosisDTO>(new DiagnosisDTO(newDiagnosis), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public List<DiagnosisDTO> getAllDiagnosis(){
		return 
			this.diagnosisService.findAllDiagnosis().stream()
				.map(DiagnosisDTO::new)
				.collect(Collectors.toList());
	}
	
	//TODO: replantear relacion entre diagnostico y "illness" porque un mismo diagnostico
	//en distintas personas puede tener distintos sintomas
	
	@PutMapping("/{diagnosisId}/add/{illnessId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void addIllness(@PathVariable Long diagnosisId,@PathVariable Long illnessId) {
		Illness dbIllness = this.IllnessService.findIllnessById(illnessId);
		Diagnosis dbDiagnosis = this.diagnosisService.findDiagnosisById(diagnosisId);
		
		dbDiagnosis.addIllness(dbIllness);
		this.diagnosisService.updateDiagnosis(dbDiagnosis);
	}
}
