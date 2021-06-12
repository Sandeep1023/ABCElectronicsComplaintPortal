package com.abc.ecp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abc.ecp.entities.Client;
import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;

@Repository
public interface IComplaintRepository extends JpaRepository<Complaint, Integer>{


public List<Complaint> findComplaintByStatus(String status);




	//@Query("select * from Complaint c where c.status=open")
	//List<Complaint> getClientAllOpenComplaints(Client client);
	
}
