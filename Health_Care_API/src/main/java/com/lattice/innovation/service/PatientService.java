package com.lattice.innovation.service;

import java.util.List;

import com.lattice.innovation.payload.DoctorDto;
import com.lattice.innovation.payload.PatientDto;

public interface PatientService {

	PatientDto createPatient(PatientDto patientDto);
	//update
	PatientDto updatePatient(PatientDto patientDto,int id);
	//delete
	void deletePatient(int id);
	//read
	PatientDto getPatient(int id);
	//readALL
	List<PatientDto> getAllPatient();
}
