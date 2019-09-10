package com.quest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.quest.validators.BirthDateConstraint;
import com.quest.validators.ContactNumberConstraint;

@Entity
public class User {
	@Id
	@NotBlank(message = "PPS cannot be blank")
	private String ppsNumber;
	
	@NotBlank(message = "Name cannot be blank")
	@Size(max=25,message = "Max 25 Characters allowed")
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="Birthdate cannot be blank")
	@BirthDateConstraint(message="Age should be above 16 / Future dates not allowed")
	private Date date;
	
	@ContactNumberConstraint(message = "Contact Number should begin with 08")
	private String phoneNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	public User() {
	}
	
	public User(String ppsNumber, String name, Date date, String phoneNumber) {
		super();
		this.ppsNumber = ppsNumber;
		this.name = name;
		this.date = date;
		this.phoneNumber = phoneNumber;
	}

	public String getPpsNumber() {
		return ppsNumber;
	}

	public void setPpsNumber(String ppsNumber) {
		this.ppsNumber = ppsNumber;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
