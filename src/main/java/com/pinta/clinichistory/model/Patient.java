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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToMany
	@JoinTable(name = "patient_reason",
			joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "reason_id", referencedColumnName = "id")
			)
	private List<Reason> reasons;
	
	@ManyToOne
	@JoinColumn(name = "diagnosis_id")
	private Diagnosis diagnosis;
	//segun el modelo en la DB un paciente siempre deberia tener un diagnostico para
	//evitar nulos en tabla
	//motivo de consulta ej: "diarrea"
	//enfermedad actual explicacion detallada de lo que le pasa
	//antecedentes personales 
	//			-patalogicos: enfermedad infancia,
	//						enfermedades de ahora, alergias, traumatismos, ciru
	//			-Habitos: .Fumar, alimentacion,
	//antecedense socioeconomicos.
	
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

	public List<Reason> getReasons() {
		return reasons;
	}

	public void setReasons(List<Reason> reasons) {
		this.reasons = reasons;
	}
	
	
}
