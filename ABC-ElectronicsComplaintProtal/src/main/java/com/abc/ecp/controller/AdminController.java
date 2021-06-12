package com.abc.ecp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.exception.InvalidComplaintIdException;
import com.abc.ecp.exception.InvalidEngineerIdException;
import com.abc.ecp.service.IAdminService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	IAdminService adminService;
	
	@PostMapping("/save")
	@ApiOperation("adding and Engineer")
	public ResponseEntity<Engineer> save(@Valid @RequestBody Engineer engineer) {
		Engineer eng = adminService.addEngineer(engineer);
		return new ResponseEntity<>(eng, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/remove/{engineerId}")
	@ApiOperation("remove an existing engineer")
	public ResponseEntity<Void> remove(@PathVariable int engineerId) throws InvalidEngineerIdException{
		logger.info("removing a engineer!!");
		adminService.removeEngineer(engineerId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@GetMapping("/get complaints by products/{productName}")
	public List<Complaint> getComplaintByProduct(@Valid @PathVariable String productName) {
	return adminService.getComplaintsByProducts(productName);
	}
	@GetMapping("/getEngineer/{complaintId}")
	@ApiOperation("Get engineer")
	public Optional<Engineer> getEngineer(@Valid @PathVariable Integer complaintId) throws InvalidComplaintIdException {
		return adminService.getEngineer(complaintId);
	}
	
	@GetMapping("/getComplaintsByStatus/{status}")
	public List<Complaint> getcomplaint(@Valid @RequestBody String  status){
		return adminService.getComplaintsByStatus(status);
		}
	
	
}