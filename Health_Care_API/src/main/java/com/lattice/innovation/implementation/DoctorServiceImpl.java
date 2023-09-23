package com.lattice.innovation.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lattice.innovation.entites.Doctor;
import com.lattice.innovation.exception.ContentNotMatchException;
import com.lattice.innovation.exception.ResourceNotFoundException;
import com.lattice.innovation.global.SpecialitySetter;
import com.lattice.innovation.payload.DoctorDto;
import com.lattice.innovation.repository.DoctorRepository;
import com.lattice.innovation.service.DoctorService;

import jakarta.validation.ValidationException;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public DoctorDto createDoctor(DoctorDto doctorDto){
		Doctor doctor = this.mapper.map(doctorDto, Doctor.class);
		if (doctor.getCity().equalsIgnoreCase("delhi") || doctor.getCity().equalsIgnoreCase("noida")
				|| doctor.getCity().equalsIgnoreCase("faridabad")) {

		} else {
			throw new ContentNotMatchException("Doctor only available at Delhi,Noida and faridabad", "city");
		}
		SpecialitySetter speciality = new SpecialitySetter();
		if (doctor.getSpeciality().equalsIgnoreCase(speciality.getSPECIALITY().get(0))
				|| doctor.getSpeciality().equalsIgnoreCase(speciality.getSPECIALITY().get(1))
				|| doctor.getSpeciality().equalsIgnoreCase(speciality.getSPECIALITY().get(2))
				|| doctor.getSpeciality().equalsIgnoreCase(speciality.getSPECIALITY().get(3))) {
			System.out.println("criteria match");

		} else {
			throw new ContentNotMatchException(
					"Only Orthopedic,ENT specialist,Gynecology,Dermatology Doctor only available ", "speciality");

		}
		System.out.println(doctorDto.getPhoneNo());
		if(doctorDto.getPhoneNo()<=1000000000) {
			throw new ValidationException("Phone Number Must be greater than 10 digit");
		}
		Doctor save = this.doctorRepository.save(doctor);
		return this.mapper.map(save, DoctorDto.class);
	}

	@Override
	public DoctorDto updateDoctor(DoctorDto doctorDto, int id) {
		Doctor doctor = this.doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor Id", id));
		doctor.setCity(doctorDto.getCity());
		doctor.setEmail(doctorDto.getEmail());
		doctor.setName(doctorDto.getName());
		if(doctorDto.getPhoneNo()<=1000000000) {
			throw new ValidationException("Phone Number Must be greater than 10 digit");
		}
		doctor.setPhoneNo(doctorDto.getPhoneNo());
		doctor.setSpeciality(doctorDto.getSpeciality());
		if (doctor.getCity().equalsIgnoreCase("delhi") || doctor.getCity().equalsIgnoreCase("noida")
				|| doctor.getCity().equalsIgnoreCase("faridabad")) {

		} else {
			throw new ContentNotMatchException("Doctor only available at Delhi,Noida and faridabad", "city");
		}
		SpecialitySetter speciality = new SpecialitySetter();
		if (doctor.getSpeciality().equalsIgnoreCase(speciality.getSPECIALITY().get(0))
				|| doctor.getSpeciality().equalsIgnoreCase(speciality.getSPECIALITY().get(1))
				|| doctor.getSpeciality().equalsIgnoreCase(speciality.getSPECIALITY().get(2))
				|| doctor.getSpeciality().equalsIgnoreCase(speciality.getSPECIALITY().get(3))) {
			System.out.println("criteria match");
		} else {
			throw new ContentNotMatchException(
					"Only Orthopedic,ENT specialist,Gynecology,Dermatology Doctor only available ", "speciality");

		}
		Doctor updatedDoctor = this.doctorRepository.save(doctor);
		return this.mapper.map(updatedDoctor, DoctorDto.class);
	}

	@Override
	public void deleteDoctor(int id) {
		Doctor doctor = this.doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor Id", id));
		this.doctorRepository.delete(doctor);
	}

	@Override
	public DoctorDto getDoctor(int id) {
		Doctor doctor = this.doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor Id", id));

		return this.mapper.map(doctor, DoctorDto.class);

	}

	@Override
	public List<DoctorDto> getAllDoctors() {
		List<Doctor> doctors = this.doctorRepository.findAll();
		List<DoctorDto> patientsDto = doctors.stream().map(doctor -> this.mapper.map(doctor, DoctorDto.class))
				.collect(Collectors.toList());
		return patientsDto;
	}

}
