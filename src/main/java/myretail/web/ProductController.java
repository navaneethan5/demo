package myretail.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myretail.domain.Product;
import myretail.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable Long id) {
		Product product = productService.findOne(id);
		return product;
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.GET, params = {"category"})
	public List<Product> getProductsByCategory(@RequestParam("category") String category) {
		List<Product> products = productService.findByCategory(category);
		return products;
	}

}
