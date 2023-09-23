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

import com.lattice.innovation.implementation.PatientServiceImpl;
import com.lattice.innovation.payload.ApiResponse;
import com.lattice.innovation.payload.PatientDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	

	@Autowired
	PatientServiceImpl serviceImpl;
	@PostMapping("/")
	public ResponseEntity<PatientDto> createPatient(@Valid @RequestBody PatientDto PatientDto) {
		//Patient name ,city,email,password,symptoms needed in order to create patient.

		PatientDto createPatient= serviceImpl.createPatient(PatientDto);
		return new ResponseEntity<PatientDto>(createPatient,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PatientDto> findPatient(@PathVariable("id") int id){
		PatientDto patientDto = this.serviceImpl.getPatient(id);
		return new ResponseEntity<PatientDto>(patientDto,HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<PatientDto>> getAllPatient(){
		List<PatientDto> patientDtos = this.serviceImpl.getAllPatient();
		return new ResponseEntity<List<PatientDto>>(patientDtos,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deletePatient(@PathVariable("id") int id){
		this.serviceImpl.deletePatient(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Patient Deleted Succesfully",true),HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<PatientDto> updatePatient(@Valid @RequestBody PatientDto patientDto,@PathVariable("id") int id){
		//Patient name ,city,email,password,symptoms needed in order to create patient.

		PatientDto updatePatient = this.serviceImpl.updatePatient(patientDto,id);
		return new ResponseEntity<PatientDto>(updatePatient,HttpStatus.OK);
	}

}
