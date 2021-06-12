package com.abc.ecp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abc.ecp.dto.ComplaintResponse;
import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

	List<Complaint> getByProductName(String productName);

	//@Query("SELECT new com.cg.cp.dto.ProductResponse(p.productCategoryName , c.complaint)FROM Product p JOIN p.complaint c")
	//public List<ComplaintResponse> getJoinInfo();
}
