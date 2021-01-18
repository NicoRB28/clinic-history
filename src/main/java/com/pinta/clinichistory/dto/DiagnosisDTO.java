package com.pinta.clinichistory.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.pinta.clinichistory.model.Diagnosis;


public class DiagnosisDTO {
	
	private Long id;
	
	private String name;
	//TODO: evaluar si cambiar 'illness' por 'symptoms'
	private List<IllnessDTO> illnesses;
	

	public DiagnosisDTO() {
		
	}
	
	public DiagnosisDTO(Diagnosis data) {
		this.setId(data.getId());
		this.setName(data.getName());
		this.illnesses = 
				data.getIllnesses().stream()
								   .map(IllnessDTO::new)
								   .collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<IllnessDTO> getIllnesses() {
		return illnesses;
	}

	public void setIllnesses(List<IllnessDTO> illnesses) {
		this.illnesses = illnesses;
	}
	
	
	
}
