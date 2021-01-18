package com.pinta.clinichistory.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.pinta.clinichistory.model.Illness;

public class IllnessDTO {
	
	private Long id;

	private String name;

	private String description;

	private List<IllnessDTO> complications;
	
	public IllnessDTO(Illness data) {
		this.setId(data.getId());
		this.setName(data.getName());
		this.setDescription(data.getDescription());
		this.complications = 
				data.getComplications().stream()
					.map(IllnessDTO::new).collect(Collectors.toList());
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<IllnessDTO> getComplications() {
		return complications;
	}

	public void setComplications(List<IllnessDTO> complications) {
		this.complications = complications;
	}
	
	

}
