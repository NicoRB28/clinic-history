package com.pinta.clinichistory.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinta.clinichistory.model.Treatment;
import com.pinta.clinichistory.repository.TreatmentRepository;
import com.pinta.clinichistory.service.TreatmentService;

@Service
public class TreatmentServiceImpl implements TreatmentService {
	
	@Autowired
	private TreatmentRepository treatmentRepository;
	
	@Override
	public Treatment findTreatmentById(Long id) throws EntityNotFoundException {
		return treatmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public Treatment createTreatment(Treatment treatment) {
		return treatmentRepository.save(treatment);
	}

	@Override
	public List<Treatment> findAllTreatment() {
		return StreamSupport.stream(treatmentRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public void deleteTreatment(Treatment treatment){
		treatmentRepository.delete(treatment);
	}

	@Override
	public void deleteTreatmentById(Long id) {
		treatmentRepository.deleteById(id);
		
	}

	@Override
	public void updateTreatment(Treatment treatment) {
		Treatment treatmentInDb = this.findTreatmentById(treatment.getId());
		treatmentInDb.setDescription(treatment.getDescription());
		
		treatmentRepository.save(treatmentInDb);
	}

}
