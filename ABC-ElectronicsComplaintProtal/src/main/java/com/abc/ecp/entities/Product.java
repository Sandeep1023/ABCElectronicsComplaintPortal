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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	// @Pattern(regexp = "^[a-zA-Z0-9]{8}", message = "length must be 8")
	private String modelNumber;
	//private int engineerid;

	@Column(name = "productName")
	@NotNull
	private String productName;

	@Column(name = "productCategoryName")
	@NotNull
	private String productCategoryName;

	@Column(name = "dateofPurchase")
	@NotNull

	private Date dateofPurchase;

	@Column(name = "warrantyYears")
	@NotNull
	private int warrantyYears;

	@Column(name = "warrantyDate")
	private Date warrantyDate;
	
	//@OneToMany( targetEntity = Complaint.class,cascade= CascadeType.ALL)
	//private List<Product> product;
	
}
