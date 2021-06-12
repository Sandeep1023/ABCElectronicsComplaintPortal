package com.abc.ecp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecp.entities.Complaint;
import com.abc.ecp.entities.Engineer;
import com.abc.ecp.entities.Product;
import com.abc.ecp.exception.InvalidModelNumberException;
import com.abc.ecp.exception.invalidProductIdException;
import com.abc.ecp.service.IProductService;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/product")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private IProductService service;

	@PostMapping("/save")
	@ApiOperation("Add product")
	public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
		logger.info("Adding a product :" + product);
		Product prod = service.addProduct(product);
		return new ResponseEntity<>(prod, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{productId}")
	@ApiOperation("Delete a product")
	public ResponseEntity<Product> delete(@PathVariable Integer productId) {
		logger.info("deleting a product");
		Product prod = service.removeProducts(productId);
		return new ResponseEntity<>(prod, HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getProduct/{productId}")
	public Optional<Product> getProduct(@PathVariable Integer productId) throws invalidProductIdException {
		logger.info("fetching all products");
		return service.getProductById(productId);
	}

//	@PutMapping("/update")
//	@ApiOperation("Update product warranty")
//	public void update(@Valid @RequestBody String modelNumber) throws InvalidModelNumberException {
//		logger.info("Updating a customer!!");
//		service.updateProductWarranty(modelNumber);
//	}

	@PutMapping("/update")
	@ApiOperation("Update an Existing product warranty")
	public Product update(@Valid @RequestBody int productId) throws InvalidModelNumberException {
		logger.info("Updating a customer!!");
		return service.updateProductWarranty(productId);
		
		
	
	}
	
	@GetMapping("/getProductComplaints/{productCategoryName}")
	@ApiOperation("Get Product Complaints")
	public List<Complaint> fetch(@PathVariable String productCategoryName) {
		return service.getProductComplaints(productCategoryName);
	}

}
