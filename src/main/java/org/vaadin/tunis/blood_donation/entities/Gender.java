package org.vaadin.tunis.blood_donation.entities;

public enum Gender {
	MALE("Male"), FEMALE("Female");

	private final String gender;

	private Gender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}
}
