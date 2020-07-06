package com.boa.customer.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class FullName {

	@Column(name="First_Name",length = 50,nullable = false)
	private String firstName;
	@Column(name="Last_Name",length = 50,nullable = false)
	private String lastName;
	@Column(name="Middle_Name",length = 50)
	private String middleName;
}
