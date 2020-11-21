package com.pinta.clinichistory.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.pinta.clinichistory.model.Diagnosis;
import com.pinta.clinichistory.repository.DiagnosisRepository;
import com.pinta.clinichistory.service.DiagnosisService;

public class DiagnosisServiceImpl implements DiagnosisService{
	
	@Autowired
	private DiagnosisRepository diagnosisRepository;
	
	@Override
	public Diagnosis createDiagnosis(Diagnosis diagnosis) {
		return diagnosisRepository.save(diagnosis);
	}

	@Override
	public Diagnosis findDiagnosisById(Long id) throws EntityNotFoundException {
		return diagnosisRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public void deleteDiagnosisById(Long id) throws EntityNotFoundException {
		diagnosisRepository.deleteById(id);
	}

	@Override
	public void deleteDiagnosis(Diagnosis diagnosis) throws EntityNotFoundException {
		diagnosisRepository.delete(diagnosis);		
	}

	@Override
	public void updateDiagnosis(Diagnosis diagnosis) {
		Diagnosis diagnosisDb = diagnosisRepository.findById(diagnosis.getId()).orElseThrow(EntityNotFoundException::new);
		
		diagnosisDb.setName(diagnosis.getName());
		
		diagnosisRepository.save(diagnosisDb);
	}

	@Override
	public List<Diagnosis> findAllDiagnosis() {
		return StreamSupport.stream(diagnosisRepository.findAll()
													   .spliterator(),false)
													   .collect(Collectors.toList());
	}

}
