package com.pinta.clinichistory.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinta.clinichistory.model.Reason;
import com.pinta.clinichistory.repository.ReasonRepository;
import com.pinta.clinichistory.service.ReasonService;

@Service
public class ReasonServiceImpl implements ReasonService{

	@Autowired
	private ReasonRepository reasonRepository;
	
	@Override
	public Reason createReason(Reason reason) {
		return reasonRepository.save(reason);
	}

	@Override
	public Reason findReasonById(Long reasonId) {
		return reasonRepository.findById(reasonId).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<Reason> findAllReasons() {
		return StreamSupport.stream(reasonRepository
							.findAll()
							.spliterator(), false)
							.collect(Collectors.toList());
	}

	@Override
	public void deleteReason(Reason reason){
		reasonRepository.delete(reason);	
	}

	@Override
	public void deleteReasonById(Long id){
		reasonRepository.deleteById(id);
	}

	@Override
	public void updateReason(Reason reason) throws EntityNotFoundException {
		Reason reasonInDb = this.findReasonById(reason.getId());
		reasonInDb.setName(reason.getName());
		reasonRepository.save(reasonInDb);
	}

	@Override
	public Reason findByName(String name) {
		return this.reasonRepository.findByName(name);
	}
}
