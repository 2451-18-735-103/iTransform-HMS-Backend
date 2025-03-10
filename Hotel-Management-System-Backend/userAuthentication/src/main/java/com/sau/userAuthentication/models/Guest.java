package com.sau.userAuthentication.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "guest")
public class Guest {
	
	@Id
	   private String guestId;
	   @NotBlank(message = "guestName cannot be empty")
	   @Size(min = 3, max = 50, message = "guestName should be between 3 and 50 characters")
	   private String guestName;
	  // @Digits(integer = 10, fraction = 0, message = "guestContact should be a 10-digit number")
	  // private long guestContact;
	   @NotBlank(message = "guestContact cannot be empty")
	   @Pattern(regexp = "\\d{10}", message = "guestContact should be a 10-digit phone number")
	   private String guestContact;
	   @Pattern(regexp = "^\\w+@gmail\\.com$", message = "Invalid Gmail email address")
	   private String guestEmail;
	   @NotBlank(message = "guestGender cannot be empty")
	   @Size(max = 7, message = "guestGender should be at most 7 characters")
	   private String guestGender;
	   @NotBlank(message = "guestAddress cannot be empty")
	   @Size(max = 100, message = "guestAddress should be at most 100 characters")
	   private String guestAddress;
	   
	   public Guest() {
		   
	   }
	   
	   
	public Guest(String guestId,
			@NotBlank(message = "guestName cannot be empty") @Size(min = 3, max = 50, message = "guestName should be between 3 and 50 characters") String guestName,
			@NotBlank(message = "guestContact cannot be empty") @Pattern(regexp = "\\d{10}", message = "guestContact should be a 10-digit phone number") String guestContact,
			@Pattern(regexp = "^\\w+@gmail\\.com$", message = "Invalid Gmail email address") String guestEmail,
			@NotBlank(message = "guestGender cannot be empty") @Size(max = 7, message = "guestGender should be at most 7 characters") String guestGender,
			@NotBlank(message = "guestAddress cannot be empty") @Size(max = 100, message = "guestAddress should be at most 100 characters") String guestAddress) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestContact = guestContact;
		this.guestEmail = guestEmail;
		this.guestGender = guestGender;
		this.guestAddress = guestAddress;
	}
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestContact() {
		return guestContact;
	}
	public void setGuestContact(String guestContact) {
		this.guestContact = guestContact;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public String getGuestGender() {
		return guestGender;
	}
	public void setGuestGender(String guestGender) {
		this.guestGender = guestGender;
	}
	public String getGuestAddress() {
		return guestAddress;
	}
	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}
	     
	  
	}
	