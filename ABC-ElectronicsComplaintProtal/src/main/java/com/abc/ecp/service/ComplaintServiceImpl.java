package com.abc.ecp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecp.entities.Client;
import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.entities.Product;
import com.abc.ecp.exception.InvalidComplaintIdException;
import com.abc.ecp.exception.InvalidModelNumberException;
import com.abc.ecp.exception.OutOfWarrentyException;
import com.abc.ecp.repository.IComplaintRepository;
import com.abc.ecp.repository.IEngineerRepository;
import com.abc.ecp.repository.IProductRepository;

@Service
public class ComplaintServiceImpl implements IComplaintService {

	@Autowired
	IComplaintRepository complaintRepository;
	@Autowired
	IEngineerRepository engineerRepository;

	Logger logger = LoggerFactory.getLogger(ComplaintServiceImpl.class);

	// @Autowired
	private Product product;

	// @Autowired
	private Complaint complaint;

	@Autowired
	IProductRepository productRepository;

	@Override
	public Complaint addComplaint(Complaint complaint) {

		return complaintRepository.save(complaint);
	}

	@Override
	public Complaint bookComplaint(int clientId, String productModelNumber, Date date)
			throws OutOfWarrentyException, InvalidModelNumberException {
		logger.info("inside bookComplaint method of ComplaintServiceImpl");
		if (productModelNumber.equals(product.getModelNumber())) {
			// LocalDate d1=LocalDate.now();
			Date date2 = product.getDateofPurchase();
			long diff = date2.getTime() - date.getTime();
			long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			if (days > 365) {
				throw new OutOfWarrentyException();
			}
			throw new InvalidModelNumberException();
		}

		return complaintRepository.save(bookComplaint(clientId, productModelNumber, date));
	}

	@Override
	public List<Complaint> getClientAllComplaints(Client client) {
		return complaintRepository.findAll();
	}

	@Override
	public List<Complaint> getClientAllOpenComplaints(Client client) {
		String status = complaint.getStatus();
		if (status == "open") {
			return complaintRepository.findAll();
		}
		return null;

	}

	/*@Override
	public Optional<Engineer> getEngineer(int complaintId) throws InvalidComplaintIdException {
		Optional<Complaint> complaint = complaintRepository.findById(complaintId);
		if (!complaint.isPresent())
			throw new InvalidComplaintIdException();
		return engineerRepository.findById(complaintId);
		
	}*/

	@Override
	public Complaint getProductByComplaint(int complaintId) throws InvalidComplaintIdException {
		Optional<Complaint> product = complaintRepository.findById(complaintId);
		if (!product.isPresent())
			throw new InvalidComplaintIdException();
		return product.get();
	}

}
