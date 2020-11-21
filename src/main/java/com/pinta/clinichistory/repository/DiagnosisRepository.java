package com.pinta.clinichistory.repository;

import org.springframework.data.repository.CrudRepository;

import com.pinta.clinichistory.model.Diagnosis;

public interface DiagnosisRepository extends CrudRepository<Diagnosis, Long> {

}
