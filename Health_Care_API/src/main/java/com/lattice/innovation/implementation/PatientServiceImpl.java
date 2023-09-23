package com.lattice.innovation.implementation;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lattice.innovation.entites.Doctor;
import com.lattice.innovation.entites.Patient;
import com.lattice.innovation.exception.ContentNotMatchException;
import com.lattice.innovation.exception.ResourceNotFoundException;
import com.lattice.innovation.global.SpecialitySetter;
import com.lattice.innovation.global.SymptomsSetter;
import com.lattice.innovation.payload.PatientDto;
import com.lattice.innovation.repository.DoctorRepository;
import com.lattice.innovation.repository.PatientRepository;
import com.lattice.innovation.service.PatientService;

import jakarta.validation.ValidationException;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired 
	private ModelMapper mapper;
	@Override
	public PatientDto createPatient(PatientDto patientDto) {
		System.out.println("---------------------checking----------------------");
		Patient patient = this.mapper.map(patientDto, Patient.class);
		SpecialitySetter speciality= new SpecialitySetter();
		SymptomsSetter symptoms= new SymptomsSetter();
		Random rndm= new Random();
		int count=0;
		if(patient.getPhoneNo()<=1000000000) {
			throw new ValidationException("Phone Number Must be greater than 10 digit");
		}
		if(patient.getCity().equalsIgnoreCase("delhi")||patient.getCity().equalsIgnoreCase("noida")||patient.getCity().equalsIgnoreCase("faridabad")) {
		}else {
		throw new ContentNotMatchException("We are still waiting to expand to your location", "City");
		}
		if(patient.getSymptoms().equalsIgnoreCase("Dysmenorrhea")){
			Optional<List<Doctor>> optionalDoctors = this.doctorRepository.getDoctorBySpeciality(speciality.getSPECIALITY().get(1));
			List<Doctor> doctors = optionalDoctors.get();
		      Doctor doctor = doctors.get(rndm.nextInt(doctors.size()));
			patient.setDoctor(doctor);
			doctor.setPatient(List.of(patient));
		}
		if(patient.getSymptoms().equalsIgnoreCase("Arthritis")||patient.getSymptoms().equalsIgnoreCase("Back Pain")||patient.getSymptoms().equalsIgnoreCase("Tissue Injury")) {
			Optional<List<Doctor>> optionalDoctors = this.doctorRepository.getDoctorBySpeciality(speciality.getSPECIALITY().get(0));
			List<Doctor> doctors = optionalDoctors.get();
//			System.out.println(doctors);
		      Doctor doctor = doctors.get(rndm.nextInt(doctors.size()));
			patient.setDoctor(doctor);
			doctor.setPatient(List.of(patient));

		}
		if(patient.getSymptoms().equalsIgnoreCase("Skin infection")||patient.getSymptoms().equalsIgnoreCase("skin burn")){
			Optional<List<Doctor>> optionalDoctors = this.doctorRepository.getDoctorBySpeciality(speciality.getSPECIALITY().get(2));
			List<Doctor> doctors = optionalDoctors.get();
		      Doctor doctor = doctors.get(rndm.nextInt(doctors.size()));
			patient.setDoctor(doctor);
			doctor.setPatient(List.of(patient));

		}
		if(patient.getSymptoms().equalsIgnoreCase("Ear pain")){
			Optional<List<Doctor>> optionalDoctors = this.doctorRepository.getDoctorBySpeciality(speciality.getSPECIALITY().get(3));
			List<Doctor> doctors = optionalDoctors.get();
		      Doctor doctor = doctors.get(rndm.nextInt(doctors.size()));
			patient.setDoctor(doctor);
			doctor.setPatient(List.of(patient));

		}
		for(String x:symptoms.getSymptoms()) {			
			if(patient.getSymptoms().equalsIgnoreCase(x)) {
				count++;
			}
			
			}
		if(count==0) {
			throw new ContentNotMatchException("There isn’t any doctor present at your location for your symptoms","Symptoms");
		}
	
		
		Patient save = this.patientRepository.save(patient);
		return this.mapper.map(save, PatientDto.class);
	}

	@Override
	public PatientDto updatePatient(PatientDto patientDto, int id) {
		Patient patient = this.patientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient", "Patient Id", id));
		patient.setEmail(patientDto.getEmail());
		if(patient.getPhoneNo()<=1000000000) {
			throw new ValidationException("Phone Number Must be greater than 10 digit");
		}
		patient.setName(patientDto.getName());
		patient.setPhoneNo(patientDto.getPhoneNo());
		Patient updatedPatient = this.patientRepository.save(patient);
		return this.mapper.map(updatedPatient, PatientDto.class);
	}

	@Override
	public void deletePatient(int id) {
		Patient patient = this.patientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient", "Patient Id", id));
		this.patientRepository.delete(patient);
		
	}

	@Override
	public PatientDto getPatient(int id) {
		Patient patient = this.patientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient", "Patient Id", id));
		
		return this.mapper.map(patient, PatientDto.class);
	}

	@Override
	public List<PatientDto> getAllPatient() {
		List<Patient> patients = this.patientRepository.findAll();
		List<PatientDto> patientsDto = patients.stream().map(patient->this.mapper.map(patient, PatientDto.class)).collect(Collectors.toList());
		return patientsDto;
	}

}
