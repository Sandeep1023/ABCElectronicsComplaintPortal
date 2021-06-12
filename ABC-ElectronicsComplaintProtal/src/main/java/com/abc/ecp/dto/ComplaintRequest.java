package com.abc.ecp.dto;

import com.abc.ecp.entities.Complaint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComplaintRequest {

	private Complaint complaint;
}
