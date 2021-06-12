package com.abc.ecp.entities;

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

import org.springframework.data.jpa.repository.Query;

import com.abc.ecp.dto.ComplaintResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name="engineer")
@Entity
public class Engineer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int engineerId;
//	@NotNull
//	@Column(name="password")
	private String password;
//	@NotNull
//	@Column(name="engineer-name")
	private String engineerName;
//	@NotNull
//	@Column(name="engineer-domain")
	private String domain;
//	@NotNull
//	@Column(name="engineer-availability")
	private Boolean availability=true;
//	
	@OneToMany( targetEntity = Complaint.class,cascade= CascadeType.ALL)
	private List<Complaint> complaint;


//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="engineerid")
//	private int engineerId;
//	@Column(name="password")
//	@NotNull
//	@Size(min=6,max=12, message= "password should be miniumum 6 and maximum 12 Characters")
//	private String password;
//	@Column(name="enginner name")
//	@Size(min= 2 , message ="Name should be miniumum 3 characters")
//	@NotNull
//	private String engineerName;
//	@Column(name="domain")
//	@NotNull
//	private String domain;
//	//default Value = true Ask sir.
//	@Value("true")
//	private Boolean availability;
//	

	
	
}


