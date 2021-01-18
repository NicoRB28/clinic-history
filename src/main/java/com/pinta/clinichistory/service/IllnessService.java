package com.pinta.clinichistory.service;

import java.util.List;

import com.pinta.clinichistory.model.Illness;

public interface IllnessService {
	
	public List<Illness> findAllIllness();
	
	public Illness findIllnessById(Long id);
	
	public Illness createIllness(Illness newIllness);
	
	public void deleteIllness(Long id);
}
