package com.lattice.innovation.global;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SymptomsSetter {

	private ArrayList<String> symptoms= new ArrayList<String>();
	public SymptomsSetter() {
		symptoms.add("Dysmenorrhea");
		symptoms.add("Arthritis");
		symptoms.add("Back Pain");
		symptoms.add("Tissue Injury");
		symptoms.add("Skin infection");
		symptoms.add("skin burn");
		symptoms.add("Ear pain");

	}
}
