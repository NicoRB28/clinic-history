package com.pinta.clinichistory.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.pinta.clinichistory.model.Doctor;
import com.pinta.clinichistory.repository.DoctorRepository;
import com.pinta.clinichistory.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public Doctor createDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor findDoctorById(Long id) throws EntityNotFoundException {
		return doctorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public void deleteDoctorById(Long id) throws EntityNotFoundException {
		doctorRepository.deleteById(id);
	}

	@Override
	public void deleteDoctor(Doctor doctor) throws EntityNotFoundException {
		doctorRepository.delete(doctor);
	}

	@Override
	public void updateDoctor(Doctor doctor) throws EntityNotFoundException {
		Doctor doctorDb = doctorRepository.findById(doctor.getId()).orElseThrow(EntityNotFoundException::new);
		
		doctorDb.setName(doctor.getName());
		doctorDb.setPatients(doctor.getPatients());
		doctorDb.setRegistration(doctor.getRegistration());
		
		doctorRepository.save(doctorDb);
	}

	@Override
	public List<Doctor> findAllDoctors() {
		return StreamSupport.stream(doctorRepository.findAll().spliterator(),false).collect(Collectors.toList());
		
	}

}
