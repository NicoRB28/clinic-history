package com.pinta.clinichistory.repository;

import org.springframework.data.repository.CrudRepository;

import com.pinta.clinichistory.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long>{

}
