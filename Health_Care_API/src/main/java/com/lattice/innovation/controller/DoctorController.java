package com.lattice.innovation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.innovation.implementation.DoctorServiceImpl;
import com.lattice.innovation.payload.ApiResponse;
import com.lattice.innovation.payload.DoctorDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	

	@Autowired
	DoctorServiceImpl serviceImpl;
	@PostMapping("/")
	public ResponseEntity<DoctorDto> createDoctor(@Valid @RequestBody DoctorDto DoctorDto) {
		//Doctor name ,city,email,password,speciality needed in order to create doctor.
		DoctorDto createDoctor = serviceImpl.createDoctor(DoctorDto);
		return new ResponseEntity<DoctorDto>(createDoctor,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DoctorDto> findDoctor(@PathVariable("id") int id){
		DoctorDto doctorDto = this.serviceImpl.getDoctor(id);
		return new ResponseEntity<DoctorDto>(doctorDto,HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<DoctorDto>> getAllDoctor(){
		List<DoctorDto> doctorDtos = this.serviceImpl.getAllDoctors();
		return new ResponseEntity<List<DoctorDto>>(doctorDtos,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteDoctor(@PathVariable("id") int id){
		this.serviceImpl.deleteDoctor(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Doctor Deleted Succesfully",true),HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<DoctorDto> updateDoctor(@Valid @RequestBody DoctorDto doctorDto,@PathVariable("id") int id){
		//Doctor name ,city,email,password,speciality needed in order to update doctor.
		DoctorDto updateDoctorDto = this.serviceImpl.updateDoctor(doctorDto,id);
		return new ResponseEntity<DoctorDto>(updateDoctorDto,HttpStatus.OK);
	}

}
