package com.lattice.innovation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lattice.innovation.entites.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
