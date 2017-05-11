package myretail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myretail.domain.Product;
import myretail.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public List<Product> findByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	public Product findOne(Long id) {
		return productRepository.findOne(id);
	}

}
