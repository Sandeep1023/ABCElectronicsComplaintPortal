package com.abc.ecp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.exception.InvalidEngineerIdException;

@Service
public interface IEngineerService {


	public List<Complaint> getResolvedComplaintsByDate(int engineerId, LocalDate localdate);

	public List<Complaint> getComplaints();

	public Optional<Engineer> getEngineersById(int engineerId) throws InvalidEngineerIdException;

	public List<Complaint> getAllOpenComplaints(int engineerId) throws InvalidEngineerIdException;

	public List<Complaint> getAllClosedComplaints(int engineerId) throws InvalidEngineerIdException;

}
