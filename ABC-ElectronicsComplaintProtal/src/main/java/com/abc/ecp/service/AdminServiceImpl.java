package com.abc.ecp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecp.entities.Admin;
import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.entities.Product;
import com.abc.ecp.exception.InvalidComplaintIdException;
import com.abc.ecp.exception.InvalidDomainException;
import com.abc.ecp.exception.InvalidEngineerIdException;
import com.abc.ecp.repository.IAdminRepository;
import com.abc.ecp.repository.IComplaintRepository;
import com.abc.ecp.repository.IEngineerRepository;
import com.abc.ecp.repository.IProductRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	IAdminRepository adminRepository;
	@Autowired
	IEngineerRepository engineerRepository;
	@Autowired
	private IComplaintRepository complaintRepository;
	@Autowired
	private IProductRepository productRepository;

	private Product product;

	List<Complaint> complaint = new ArrayList<Complaint>();

	@Override
	public Engineer addEngineer(Engineer engineer) {
		logger.info("inside addEngineer method of AdminServiceImpl");

		return engineerRepository.save(engineer);
	}

	@Override
	public Engineer changeDomainOfEngineer(int engineerId, String newDomain)
			throws InvalidDomainException, InvalidEngineerIdException {
		Optional<Engineer> engineer = engineerRepository.findById(engineerId);
		Engineer eng = null;
		if (engineer.isPresent()) {
			eng = engineer.get();
			eng.setDomain(newDomain);
			engineerRepository.save(eng);
		}
		return eng;
	}

	@Override
	public Optional<Engineer> getEngineer(int complaintId) throws InvalidComplaintIdException {
		Optional<Complaint> complaint = complaintRepository.findById(complaintId);
		if (!complaint.isPresent())
			throw new InvalidComplaintIdException();
		return engineerRepository.findById(complaintId);
		
	}
	@Override
	public void removeEngineer(int engineerId) throws InvalidEngineerIdException {

		Optional<Engineer> customer = engineerRepository.findById(engineerId);
		if (!customer.isPresent()) {
			throw new InvalidEngineerIdException();
		}
		engineerRepository.deleteById(engineerId);
	}

	@Override
	public List<Complaint> getComplaintsByProducts(String productName) {

		return productRepository.getByProductName(productName);
	}

	@Override
	public List<Complaint> getComplaintsByStatus(String status) {

		return complaintRepository.findComplaintByStatus(status);
	}
}
//	@Override
//	public Complaint replaceEngineerFromComplaint(int complaintId) throws InvalidDomainException {
//
//	
//		return null;
//	}

