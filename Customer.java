package com.boa.customer.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="BOA_Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Customer_Id")
	private long customerId;
	@Embedded
	@Column(name="Name")
	private FullName name;
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="DOB")
	private LocalDate dob;
	@Column(name="MobileNo")
	private long mobileNo;
	@Column(name="Email_Id",length = 150)
	private String emailId;
	@Enumerated(EnumType.STRING)
	@Column(name="Gender")
	private GenderType gender;
	
	

}
