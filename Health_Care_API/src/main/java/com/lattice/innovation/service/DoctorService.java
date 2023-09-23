package com.lattice.innovation.service;

import java.util.List;

import com.lattice.innovation.payload.DoctorDto;


public interface DoctorService {

	//create
	DoctorDto createDoctor(DoctorDto doctorDto) ;
	//update
	DoctorDto updateDoctor(DoctorDto doctorDto,int id);
	//delete
	void deleteDoctor(int id);
	//read
	DoctorDto getDoctor(int id);
	//readALL
	List<DoctorDto> getAllDoctors();
}
