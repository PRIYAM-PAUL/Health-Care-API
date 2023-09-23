package com.lattice.innovation.global;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecialitySetter {
	
	private ArrayList<String> SPECIALITY= new ArrayList<String>();
	public SpecialitySetter() {
		SPECIALITY.add("Orthopedic");
		SPECIALITY.add("Gynecology");
		SPECIALITY.add("Dermatology");
		SPECIALITY.add("ENT specialist");
	}

}
