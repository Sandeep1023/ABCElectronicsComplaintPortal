package com.abc.ecp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.exception.InvalidEngineerIdException;
import com.abc.ecp.repository.IComplaintRepository;
import com.abc.ecp.repository.IEngineerRepository;

@Service
public class EngineerServiceImpl implements IEngineerService {

	Logger logger = LoggerFactory.getLogger(EngineerServiceImpl.class);
	@Autowired
	IEngineerRepository engineerRepository;
	@Autowired
	IComplaintRepository complaintRepository;

	@Override
	public List<Complaint> getResolvedComplaintsByDate(int engineerId, LocalDate localdate) {

		return null;
	}

	@Override
	public List<Complaint> getComplaints() {
		logger.info(" List of Complaints ");
		return complaintRepository.findAll();
	}

	@Override
	public List<Complaint> getAllOpenComplaints(int engineerId) throws InvalidEngineerIdException {
		Optional<Engineer> eng = engineerRepository.findById(engineerId);
		if (eng.isPresent()) {
			return complaintRepository.findComplaintByStatus("open");
		}
		throw new InvalidEngineerIdException();
	}

	@Override
	public Optional<Engineer> getEngineersById(int engineerId) throws InvalidEngineerIdException {
		Optional<Engineer> eng = engineerRepository.findById(engineerId);
		if (eng.isPresent()) {
			return engineerRepository.findById(engineerId);
		}
		throw new InvalidEngineerIdException();
	}

	@Override
	public List<Complaint> getAllClosedComplaints(int engineerId) throws InvalidEngineerIdException {
		Optional<Engineer> eng = engineerRepository.findById(engineerId);
		if (eng.isPresent()) {
			return complaintRepository.findComplaintByStatus("close");
		}
		throw new InvalidEngineerIdException();
	}

}
