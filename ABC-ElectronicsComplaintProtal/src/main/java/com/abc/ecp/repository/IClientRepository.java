package com.abc.ecp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.ecp.entities.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer>{


	Client findById(int clientId);

//public Client getClientById(String clientId); 
	//EngineerResponse getEngineersById(int engineerId);
	
	
	//@Query("SELECT new com.cg.ecp.dto.EngineerResponse(e.engineerId,d.domain) FROM Client c JOIN c.engineer e")
	//EngineerResponse getJoinInfo();
	
	//@Query("SELECT new com.cg.cs.dto.OrderResponse(c.firstName, p.pName) FROM Customer c JOIN c.products p")
	//public List<OrderResponse> getJoinInfo();
}
