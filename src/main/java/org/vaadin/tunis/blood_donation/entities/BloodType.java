package org.vaadin.tunis.blood_donation.entities;

public enum BloodType {
	O_POSITIVE("O_Positive"), O_NEGATIVE("O_Negative"), A_POSITIVE("A_Positive"), A_NEGATIVE(
			"A_Negative"), B_POSITIVE("B_Positive"), B_NEGATIVE("B_Negative"), AB_POSITIVE(
			"AB_Positive"), AB_NEGATIVE("AB_Negative");
	private final String bloodType;

	private BloodType(String type) {
		this.bloodType = type;
	}

	public String getBloodType() {
		return bloodType;
	}

}
