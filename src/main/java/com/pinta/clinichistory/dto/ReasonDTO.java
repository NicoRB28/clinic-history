package com.pinta.clinichistory.dto;

import com.pinta.clinichistory.model.Reason;

public class ReasonDTO {
	
	private Long id;
	
	private String name;
	
	public ReasonDTO() {
		
	}
	
	public ReasonDTO(Reason data) {
		this.id = data.getId();
		this.name = data.getName();
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
	
	
}
