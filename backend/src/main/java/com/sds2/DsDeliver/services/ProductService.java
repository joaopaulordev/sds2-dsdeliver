package com.sds2.DsDeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sds2.DsDeliver.dto.ProductDTO;
import com.sds2.DsDeliver.entities.Product;
import com.sds2.DsDeliver.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		
		List<Product> list = repository.findAllByOrderByName();
		
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());		
	}

}
