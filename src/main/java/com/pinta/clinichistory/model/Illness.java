package com.pinta.clinichistory.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "illness")
public class Illness {
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	private String description;
	
	@OneToMany
	private List<Illness> complications;
	
	
	public List<Illness> getComplications() {
		return complications;
	}

	public void setComplications(List<Illness> complications) {
		this.complications = complications;
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

	public Illness() {
		super();
	}
	
	
}
