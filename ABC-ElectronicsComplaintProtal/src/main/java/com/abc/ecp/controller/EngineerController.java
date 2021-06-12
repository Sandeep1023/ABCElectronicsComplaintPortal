package com.abc.ecp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecp.dto.ComplaintResponse;
import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.exception.InvalidEngineerIdException;
import com.abc.ecp.service.IEngineerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/engineer")
public class EngineerController {

	@Autowired
	IEngineerService engineerService;

	@GetMapping("/getAllOpenComplaints/{engineerId}")
	@ApiOperation("Get all the Open complaints")
	public List<Complaint> getAllOpenComplaints(@PathVariable Integer engineerId)
			throws InvalidEngineerIdException {
		return engineerService.getAllOpenComplaints(engineerId);
	}
//	@GetMapping("/{getAllReslovedComplaintsSortedBydate}")
//	@ApiOperation("Get all the resloved complaints in sorted list")
//	public List<ComplaintResponse> getAllresolvedComplaintsByDate(@PathVariable int engineerId,@PathVariable LocalDate localdate){
//		return engineerService.getResolvedComplaintsByDate(engineerId, localdate);
//		
//	}
	
	@GetMapping("/getAllClosedComplaints/{engineerId}")
	@ApiOperation("Get all the Open complaints")
	public List<Complaint> getAllClosedComplaints(@PathVariable Integer engineerId)
			throws InvalidEngineerIdException {
		return engineerService.getAllClosedComplaints(engineerId);
	}

	@GetMapping("getEngineersById/{engineerId}")
	public Optional<Engineer> getEngineersById(@PathVariable int engineerId) throws InvalidEngineerIdException {
		return engineerService.getEngineersById(engineerId);
	}

	@GetMapping("/{getAllComplaints}")
	@ApiOperation("Get all the complaints")
	public List<Complaint> getComaplaints() {
		return engineerService.getComplaints();
	}
}
