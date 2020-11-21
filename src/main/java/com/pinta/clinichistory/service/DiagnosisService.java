package com.pinta.clinichistory.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.pinta.clinichistory.model.Diagnosis;

public interface DiagnosisService {
	
	Diagnosis createDiagnosis(Diagnosis diagnosis);
	
	Diagnosis findDiagnosisById(Long id) throws EntityNotFoundException;
	
	void deleteDiagnosisById(Long id) throws EntityNotFoundException;
	
	void deleteDiagnosis(Diagnosis diagnosis) throws EntityNotFoundException;
	
	void updateDiagnosis(Diagnosis diagnosis);
	
	List<Diagnosis> findAllDiagnosis();
}
