package org.persistence;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_BLOODBANK")
public class BloodBank {

	@Id
	private long id;
	@Basic
	private String name;
	@Basic
	private String address;
	@Basic
	private String telephone;
	@Basic
	private String fax;
	@Basic
	private String positionX;
	@Basic
	private String positionY;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String param) {
		this.name = param;
	}

	public String getName() {
		return name;
	}

	public void setAddress(String param) {
		this.address = param;
	}

	public String getAddress() {
		return address;
	}

	public void setTelephone(String param) {
		this.telephone = param;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setFax(String param) {
		this.fax = param;
	}

	public String getFax() {
		return fax;
	}

	public void setPositionX(String param) {
		this.positionX = param;
	}

	public String getPositionX() {
		return positionX;
	}

	public void setPositionY(String param) {
		this.positionY = param;
	}

	public String getPositionY() {
		return positionY;
	}

}