package com.pinta.clinichistory.mapper;

import com.pinta.clinichistory.dto.PatientDTO;
import com.pinta.clinichistory.model.Patient;

public class PatientMapper {

	public static Patient patientDtoToPatient(PatientDTO patientDTO) {
		Patient patient = new Patient();
		patient.setDni(patientDTO.getDni());
		patient.setLastName(patientDTO.getLastName());
		patient.setName(patientDTO.getName());
		
		return patient;
	}
	
	public static PatientDTO fromPatientToPatientDTO(Patient data) {
		PatientDTO dto = new PatientDTO();
		dto.setId(data.getId());
		dto.setDni(data.getDni());
		dto.setLastName(data.getLastName());
		dto.setName(data.getName());
		return dto;
	}
}
