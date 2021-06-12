package com.abc.ecp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

//SLF4J : Simple Logging Facade For Java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.abc.ecp.exception.InvalidClientIdException;
import com.abc.ecp.exception.InvalidDomainException;
import com.abc.ecp.exception.InvalidEngineerIdException;
import com.abc.ecp.service.IClientService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/client")
public class ClientController {
	Logger logger = LoggerFactory.getLogger(ClientController.class);
	@Autowired
	private IClientService service;
	
	@PostMapping("/saveClient")
	@ApiOperation("Saving a Client")
	public ResponseEntity<Client> save(@Valid @RequestBody Client client) {
		logger.info("Adding a Client : " + client);
		Client cl = service.saveClient(client);
		return new ResponseEntity<>(cl, HttpStatus.CREATED);
	}
	@GetMapping("Getting Clients By ClientId/{clientId}")
	public Client getClientByClientId(@PathVariable int clientId) throws InvalidClientIdException {
		return service.getClientByClientId(clientId);
	}

	@GetMapping("getEngineersByDomain/{domain}")
	public List<Engineer> getEngineersByDomain(@PathVariable String domain) throws InvalidDomainException {
		return service.getEngineersByDomain(domain);
	}
	@PostMapping("/closing a comaplaint")
	@ApiOperation("Closing a Complaint")
	public Complaint changeComplaintStatus(@PathVariable Complaint complaint) {
		return service.changeStatusOfComplaint(complaint);
	}

}