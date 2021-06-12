package com.abc.ecp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.entities.Product;
import com.abc.ecp.exception.InvalidModelNumberException;
import com.abc.ecp.exception.invalidProductIdException;
import com.abc.ecp.repository.IComplaintRepository;
import com.abc.ecp.repository.IEngineerRepository;
import com.abc.ecp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private IProductRepository productRepository;

	@Autowired
	IEngineerRepository engineerRepository;

	@Autowired
	IComplaintRepository complaintRepository;

	List<Product> productList = new ArrayList<Product>();

	@Override
	public Product addProduct(Product product) {
		logger.info(" addProduct ");
		productList.add(product);
		return productRepository.save(product);
	}

	@Override
	public Product removeProducts(int productId) {
		productRepository.deleteById(productId);
		return productRepository.getById(productId);
	}

	@Override
	public Optional<Product> getProductById(int productId) throws invalidProductIdException {
		Optional<Product> p = productRepository.findById(productId);
		if (!p.isPresent()) {
			throw new invalidProductIdException();
		}
		return productRepository.findById(productId);
	}

	public Product updateProductWarranty(int productId) throws InvalidModelNumberException {
		Optional<Product> product = productRepository.findById(productId);
		Product p = null;
		if (product.isPresent()) {
			p = product.get();
			p.setWarrantyYears(2);
			return productRepository.save(p);
		} else
			throw new InvalidModelNumberException();
	}

	@Override
	public List<Complaint> getProductComplaints(String productCategoryName) {

		return null ;
	}

}
