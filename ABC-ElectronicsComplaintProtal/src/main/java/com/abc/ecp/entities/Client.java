package com.abc.ecp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="clientid")
	private int clientId;
	
	@NotNull
	@Size(min = 6, message = "Password should have mininum 6 characters!!")
	@Column(name="Password")
	private String password;
	
	@NotNull
	@Size(min = 3, message = "Address should have mininum 3 characters!!")
	@Column(name="Address")
	private String address;
	
	@NotNull
	//@Size(min =6,max =10, message = "Phone Number should have mininum 6 and Maximum 10 Digits!!")
	@Column(name="PhoneNumber")
	private long phoneNumber;
	
	//@OneToMany(targetEntity = Complaint.class, cascade = CascadeType.ALL)
	//JoinColumn(name = "status", referencedColumnName = "status")
	//private List<Complaint> complaint;
	
	//@JoinColumn(name = "ce_fk", referencedColumnName = "ClientId")
	//@OneToMany( cascade = CascadeType.MERGE)
	//private List<Engineer> engineer;
}
