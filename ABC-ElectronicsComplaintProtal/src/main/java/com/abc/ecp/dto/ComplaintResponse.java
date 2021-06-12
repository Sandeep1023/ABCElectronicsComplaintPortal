package com.abc.ecp.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ComplaintResponse {

	private int engineerId;
	private int complaintId;
	private String status;
	private Date complaintDate;
	
}
