package com.pinta.clinichistory.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.pinta.clinichistory.model.Treatment;

public interface TreatmentService {
	
	Treatment findTreatmentById(Long id)throws EntityNotFoundException;
	
	Treatment createTreatment(Treatment treatment);
	
	List<Treatment> findAllTreatment();
	
	void deleteTreatment(Treatment treatment)throws EntityNotFoundException;
	
	void deleteTreatmentById(Long id)throws EntityNotFoundException;
	
	void updateTreatment(Treatment treatment) throws EntityNotFoundException;
	
}
