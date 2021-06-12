package com.abc.ecp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.abc.ecp.entities.Client;
import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.exception.InvalidComplaintIdException;
import com.abc.ecp.exception.InvalidModelNumberException;
import com.abc.ecp.exception.OutOfWarrentyException;

@Service
public interface IComplaintService {

	public Complaint addComplaint(Complaint complaint);

	public Complaint bookComplaint(int clientId, String productModelNumber, Date date)
			throws OutOfWarrentyException, InvalidModelNumberException;

	public List<Complaint> getClientAllComplaints(Client client);

	public List<Complaint> getClientAllOpenComplaints(Client client);

	//Optional<Engineer> getEngineer(int complaintId) throws InvalidComplaintIdException;

	public Complaint getProductByComplaint(int complaintId) throws InvalidComplaintIdException;
}
