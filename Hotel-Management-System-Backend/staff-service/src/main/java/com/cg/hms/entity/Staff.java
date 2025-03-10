package com.cg.hms.entity;

 

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 

@Document(collection = "Staff")
public class Staff {
	  @Id
	    @NotBlank(message = "Staff ID cannot be empty")
	    private String staffId;

	    @NotBlank(message = "Staff name cannot be empty")
	    private String staffName;

	    private String address;

	    @Pattern(regexp = "^\\d+(\\.\\d+)?$", message = "Salary should be a numeric value")
	    private String salary;

	    @Email(message = "Invalid email format")
	    private String emailId;

	    @Pattern(regexp = "^[0-9]{1,3}$", message = "Age should be a numeric value between 1 and 999")
	    private String age;

	    public Staff() {}
	public Staff(@NotBlank(message = "staff Id cannot be empty") String staffId, String staffName, String address,
			String salary, String emailId, String age) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.address = address;
		this.salary = salary;
		this.emailId = emailId;
		this.age = age;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}



}