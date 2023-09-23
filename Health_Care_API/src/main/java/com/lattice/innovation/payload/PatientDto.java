package com.lattice.innovation.payload;

import org.hibernate.validator.constraints.Range;

import com.lattice.innovation.entites.Doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

	private int id;
	@Size(min = 3)
	private String name;
	@Size(max=20)
	private String city;
	@Email
	private String email;
	@Range(min=10)
	private Long phoneNo;
	private String symptoms;
	private DoctorDto doctor;
}
