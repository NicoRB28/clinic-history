package com.pinta.clinichistory.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.pinta.clinichistory.model.Doctor;

public interface DoctorService {
	
	Doctor createDoctor(Doctor doctor);
	
	Doctor findDoctorById(Long id) throws EntityNotFoundException;
	
	void deleteDoctorById(Long id) throws EntityNotFoundException;
	
	void deleteDoctor(Doctor doctor) throws EntityNotFoundException;
	
	void updateDoctor(Doctor doctor)throws EntityNotFoundException;
	
	List<Doctor> findAllDoctors();
}
