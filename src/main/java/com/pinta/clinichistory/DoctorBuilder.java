package com.pinta.clinichistory;

import java.util.List;
import java.util.function.Consumer;

import com.pinta.clinichistory.model.Doctor;
import com.pinta.clinichistory.model.Patient;

public class DoctorBuilder {
	
	private String name;
	private String registration;
	private List<Patient> patients;
	
	public DoctorBuilder with(Consumer<DoctorBuilder> builderFunction) {
		builderFunction.accept(this);
		return this;
	}
	
	public Doctor createDoctor() {
		return new Doctor(name, registration, patients);
	}
}
