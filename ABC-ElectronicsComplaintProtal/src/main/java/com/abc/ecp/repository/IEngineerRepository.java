package com.abc.ecp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;

@Repository
public interface IEngineerRepository extends JpaRepository<Engineer, Integer>{
	
	public List<Engineer> findByDomain(String domain);

	

	//@Query("SELECT new com.cg.cp.dto.ComplaintResponse(e.engineerId , c.complaintId ,c.status, c.complaintDate)FROM Engineer e JOIN e.complaint c")
	//public List<ComplaintResponse> getJoinInfo();
}
