package com.abc.ecp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // The @Entity annotation specifies that the class is an entity and is mapped to
		// a database table.

@Data
@NoArgsConstructor
@Table(name = "Admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;

	@Column(name = "password")
	@NotNull
	@Size(min = 4, message = "Password must have 4 characters")
	private String password;

	@Column(name = "contactNumber")
	@NotNull
	private long contactNumber;

	@Column(name = "emailId")
	@NotNull
	@Email(message = "Enter a valid email address!!")
	private String emailId;

}
