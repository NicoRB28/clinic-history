package com.pinta.clinichistory.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.pinta.clinichistory.model.Reason;

public interface ReasonService {
	
	Reason createReason(Reason reason);
	
	Reason findReasonById(Long reasonId);
	
	List<Reason> findAllReasons();
	
	void deleteReason(Reason reason);
	
	void deleteReasonById(Long id);
	
	void updateReason(Reason reason) throws EntityNotFoundException;
	
	Reason findByName(String name);
}
