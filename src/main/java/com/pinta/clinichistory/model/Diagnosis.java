package com.pinta.clinichistory.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pinta.clinichistory.dto.DiagnosisDTO;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy = "diagnosis")
	private List<Patient> patients;
	
	@OneToMany
	private List<Illness> illnesses;
	
	public Diagnosis() {
		
	}
	
	public Diagnosis(DiagnosisDTO data) {
		this.setName(data.getName());
		this.setId(data.getId());
		this.illnesses = 
				data.getIllnesses().stream()
				.map(Illness::new).collect(Collectors.toList());
	}
	
	public List<Patient> getPatients() {
		return patients;
	}



	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}



	public List<Illness> getIllnesses() {
		return illnesses;
	}



	public void setIllnesses(List<Illness> illnesses) {
		this.illnesses = illnesses;
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
