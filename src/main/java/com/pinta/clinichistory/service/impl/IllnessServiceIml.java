package com.pinta.clinichistory.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinta.clinichistory.model.Illness;
import com.pinta.clinichistory.repository.IllnessRepository;
import com.pinta.clinichistory.service.IllnessService;

@Service
public class IllnessServiceIml implements IllnessService {

	@Autowired
	private IllnessRepository illnessRepo;
	
	@Override
	public List<Illness> findAllIllness() {
		return
			(List<Illness>)this.illnessRepo.findAll();
	}

	@Override
	public Illness findIllnessById(Long id) {
		return this.illnessRepo.findById(id).orElseThrow(()-> new EntityNotFoundException());
	}

	@Override
	public Illness createIllness(Illness newIllness) {
		return this.illnessRepo.save(newIllness);
	}

	@Override
	public void deleteIllness(Long id) {
		this.illnessRepo.deleteById(id);
	}

}
