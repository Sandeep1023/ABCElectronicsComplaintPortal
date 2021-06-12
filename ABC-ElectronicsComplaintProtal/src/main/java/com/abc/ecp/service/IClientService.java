package com.abc.ecp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abc.ecp.entities.Client;
import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;

@Service
public interface IClientService {

	Client saveClient(Client client);

	Client getClientByClientId(int clientId);

	Complaint changeStatusOfComplaint(Complaint complaint);

	public List<Engineer> getEngineersByDomain(String domain);
}
