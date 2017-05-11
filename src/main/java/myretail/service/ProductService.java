package myretail.service;

import java.util.List;

import myretail.domain.Product;

public interface ProductService {
	
	public List<Product> findAll();
	public Product findOne(Long id);
	public List<Product> findByCategory(String category);

}
