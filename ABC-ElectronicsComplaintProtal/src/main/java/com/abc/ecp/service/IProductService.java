package com.abc.ecp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.entities.Product;
import com.abc.ecp.exception.InvalidModelNumberException;
import com.abc.ecp.exception.invalidProductIdException;

@Service
public interface IProductService {

	public Product addProduct(Product product);

	public Product removeProducts(int productId);

	List<Complaint> getProductComplaints(String productCategoryName);

	Optional<Product> getProductById(int productId)throws invalidProductIdException;

	public Product updateProductWarranty(int productId) throws InvalidModelNumberException;

}
