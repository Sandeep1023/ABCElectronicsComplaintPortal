package com.abc.ecp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecp.entities.Client;
import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.repository.IClientRepository;
import com.abc.ecp.repository.IComplaintRepository;
import com.abc.ecp.repository.IEngineerRepository;

@Service
public class ClientServiceImpl implements IClientService {
	Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private IClientRepository clientRepository;
	// @Autowired
	// EngineerResponse engineerResponse;
	@Autowired
	IEngineerRepository engineerRepository;
	@Autowired
	IComplaintRepository complaintRepository;

	@Override
	public Client saveClient(Client client) {
		// TODO Auto-generated method stub
		return clientRepository.save(client);
	}

	@Override
	public Client getClientByClientId(int clientId) {
		// TODO Auto-generated method stub
		return clientRepository.findById(clientId);
	}
	@Override
	public List<Engineer> getEngineersByDomain(String domain) {
		return engineerRepository.findByDomain(domain);

	}

	@Override
	public Complaint changeStatusOfComplaint(Complaint complaint) {
		if (complaint.getStatus().equalsIgnoreCase("open")) {
			complaint.setStatus("close");

		}

		return complaint;
		// if(status.equals("open")){
		// status="close";
		// }
		// return complaint;

	}

}