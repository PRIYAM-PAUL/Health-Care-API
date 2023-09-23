package com.lattice.innovation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lattice.innovation.entites.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	Optional<List<Doctor>> getDoctorBySpeciality(String Speciality);
}
