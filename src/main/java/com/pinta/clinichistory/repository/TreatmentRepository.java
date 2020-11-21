package com.pinta.clinichistory.repository;

import org.springframework.data.repository.CrudRepository;

import com.pinta.clinichistory.model.Treatment;

public interface TreatmentRepository extends CrudRepository<Treatment, Long>{

}
