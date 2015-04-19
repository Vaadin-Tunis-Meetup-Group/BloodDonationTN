package org.persistence;

import javax.persistence.*;

@Entity
@Table(name = "T_USER")
public class User {

	@Id
	private long id;
	@Basic
	private String fullName;
	@Basic
	private String bloodType;
	@Basic
	private String telephone;
	@Basic
	private String email;
	@Basic
	private String address;
	@Basic
	private String gender;
	@Basic
	private String stat;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFullName(String param) {
		this.fullName = param;
	}

	public String getFullName() {
		return fullName;
	}

	public void setBloodType(String param) {
		this.bloodType = param;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setTelephone(String param) {
		this.telephone = param;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setEmail(String param) {
		this.email = param;
	}

	public String getEmail() {
		return email;
	}

	public void setAddress(String param) {
		this.address = param;
	}

	public String getAddress() {
		return address;
	}

	public void setGender(String param) {
		this.gender = param;
	}

	public String getGender() {
		return gender;
	}

	public void setStat(String param) {
		this.stat = param;
	}

	public String getStat() {
		return stat;
	}

}