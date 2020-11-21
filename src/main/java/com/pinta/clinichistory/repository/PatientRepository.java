package com.pinta.clinichistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pinta.clinichistory.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long>{
	
	@Query(nativeQuery = true, value = "SELECT p.* FROM patient AS p "
									 + "INNER JOIN patient_treatment as pt "
									 + "on (p.id = pt.patient_id) inner join "
									 + "treatment as t on (pt.treatment_id "
									 + "= t.id) WHERE treatment_id = :treatmentId"
			
			)
	List<Patient> findByTreatmentId(@Param("treatmentId")Long treatmentId);
	
	@Query(nativeQuery = true, value = "SELECT p.* FROM patient AS p "
									 + "WHERE p.diagnosis_id = :diagnosisId"
			)
	List<Patient> findByDiagnosisId(@Param("diagnosisId")Long diagnosisId);
}
