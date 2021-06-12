package com.abc.ecp.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name="complaint")
@Entity
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int complaintId;
	@Column(name = "productModelNumber")
	@NotNull
	private String productModelNumber;
	@Column(name = "complaintName")
	@NotNull
	private String complaintName;
//	@Column(name = "status")
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "open")
//	@GenericGenerator(name = "open", strategy = "open")
//	@Size(message = "Default status open")
	public String status;
	@NotNull
	@Column(name="complaintIssueDate")
	private Date complaintDate;
	//@OneToMany( targetEntity = Engineer.class,cascade= CascadeType.ALL)
	//private List<Engineer> engineer;
	
//	@OneToOne(targetEntity = Product.class,cascade= CascadeType.ALL )
//	@JoinColumn(name="cp_fk", referencedColumnName = "Id")
//	private List<Product> product;

}
