package com.abc.ecp.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.exception.InvalidComplaintIdException;
import com.abc.ecp.exception.InvalidDomainException;
import com.abc.ecp.exception.InvalidEngineerIdException;

@Service
public interface IAdminService {

	public Engineer addEngineer(Engineer engineer);

	public void removeEngineer(int engineerId) throws InvalidEngineerIdException;

	public List<Complaint> getComplaintsByProducts(String productCategoryName);

	Engineer changeDomainOfEngineer(int engineerId, String newDomain)
			throws InvalidDomainException, InvalidEngineerIdException;

	public List<Complaint> getComplaintsByStatus(String status);

	public Optional<Engineer>  getEngineer(int complaintId) throws InvalidComplaintIdException;

}
