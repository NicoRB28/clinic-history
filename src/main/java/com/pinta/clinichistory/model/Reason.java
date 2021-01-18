package com.pinta.clinichistory.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.pinta.clinichistory.dto.ReasonDTO;

@Entity
@Table(name = "reason")
public class Reason {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="reasons")
	private List<Patient> patients;
	
	public Reason() {
		this.patients = new ArrayList<>();
	}
	
	public Reason(ReasonDTO data) {
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
