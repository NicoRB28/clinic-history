package com.pinta.clinichistory.model;


import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@ManyToMany
	@JoinTable(name = "patient_treatment",
			joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "treatment_id", referencedColumnName = "id")
			)
	private List<Treatment> treatments;
	
	@ManyToMany(cascade = CascadeType.ALL )
	@JoinTable(name = "patient_reason",
			joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "reason_id", referencedColumnName = "id")
			)
	private List<Reason> reasons;
	
	@ManyToMany
	@JoinTable(name = "patient_diagnosis",
			joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "diagnosis_id", referencedColumnName = "id" )
			)
	private List<Diagnosis> diagnosis;
	
	public Patient() {
		
	}
	
	private String dni;

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}
	public void addTreatment(Treatment treatment) {
		this.treatments.add(treatment);
	}
	public void removeTreatment(Treatment treatment) {
		this.treatments.removeIf(t -> t.getId().equals(treatment.getId()));
	}

	public List<Reason> getReasons() {
		return reasons;
	}

	public void setReasons(List<Reason> reasons) {
		this.reasons = reasons;
	}
	
	public void addReason(Reason reason) {
		this.reasons.add(reason);
	}
	public boolean removeReason(Reason reason) {
		return this.reasons
				   .removeIf(r -> r.getId().equals(reason.getId()));
	}

	public List<Diagnosis> getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(List<Diagnosis> diagnosis) {
		this.diagnosis = diagnosis;
	}
	public void addDiagnosis(Diagnosis diagnosis) {
		this.diagnosis.add(diagnosis);
	}
	public void removeDiagnosis(Diagnosis diagnosis) {
		this.diagnosis.removeIf(d -> d.getId().equals(diagnosis.getId()));
	}
	
	
}
