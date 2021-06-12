package com.abc.ecp.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecp.entities.Client;
import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.exception.InvalidComplaintIdException;
import com.abc.ecp.exception.InvalidModelNumberException;
import com.abc.ecp.exception.OutOfWarrentyException;
import com.abc.ecp.repository.IComplaintRepository;
import com.abc.ecp.service.IComplaintService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {
	
	@Autowired
	IComplaintService complaintService;
	
	@PostMapping("/{saveComplaint}")
	@ApiOperation("add complaint")
	public Complaint save(@Valid @RequestBody Complaint complaint) {
	
		Complaint comp = complaintService.addComplaint(complaint);
		return comp;
	}

		@PostMapping("/bookcomplaint")
		@ApiOperation("book a complaint")
		public ResponseEntity<Complaint> bookComplaint(@Valid @PathVariable Integer clientId,@PathVariable String productModelNumber,@PathVariable Date date) throws OutOfWarrentyException,InvalidModelNumberException {
			Complaint c2 = complaintService.bookComplaint(clientId,productModelNumber,date);
			return new ResponseEntity<>(c2, HttpStatus.CREATED);
		}
		
		
		@GetMapping("/getClientAllComplaints/{client}")
		@ApiOperation("Get all complaints")
		public List<Complaint> getClientAllComplaints(@PathVariable Client client){
			return complaintService.getClientAllComplaints(client);
		}
		
		@GetMapping("/getClientAllOpenComplaints/{client}")
		@ApiOperation("Get all open complaints")
		public List<Complaint> getClientAllOpenComplaints(@PathVariable Client client){
			return complaintService.getClientAllOpenComplaints(client);
		}
		
		/*@GetMapping("/getEngineer/{complaintId}")
		@ApiOperation("Get engineer")
		public Optional<Engineer> getEngineer(@Valid @PathVariable Integer complaintId) throws InvalidComplaintIdException {
			return complaintService.getEngineer(complaintId);
		}*/
		
		@GetMapping("/getProductByComplaint/{complaintId}")
		@ApiOperation("Get product by complaintid")
		public Complaint getProductByComplaint(@Valid @PathVariable Integer complaintId) throws InvalidComplaintIdException{
			return complaintService.getProductByComplaint(complaintId);
		}
		
}
