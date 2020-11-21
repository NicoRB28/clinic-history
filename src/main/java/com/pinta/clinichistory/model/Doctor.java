package com.pinta.clinichistory.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String registration;
	
	@ManyToMany
	@JoinTable(
			name = "doctor_patient",
			joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id")
	)
	private List<Patient> patients;
	
	public Doctor(String name, String registration, List<Patient> patients) {
		this.name = name;
		this.registration = registration;
		this.patients = patients;
	}
	
	public Doctor() {
		
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

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	
}
