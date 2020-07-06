package com.boa.customer.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BOA_Customer_Address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Address_Id")
	private long addressId;
    @Column(name="Door_No",length = 5,nullable = false)
	private String doorNo;
    @Column(name="Street_Name",length = 150,nullable = false)
	private String streetName;
    @Column(name="City",length = 100,nullable = false)
	private String city;
    @Column(name="State",length = 100,nullable = false)
	private String state;
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "Customer_Id")
	private Customer customer;
}
