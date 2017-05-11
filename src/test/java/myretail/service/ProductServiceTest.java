package myretail.service;

import java.util.*;

import myretail.AbstractTest;
import myretail.domain.*;
import myretail.service.ProductService;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceTest extends AbstractTest {
	
	@Autowired
	ProductService productService;

	@Before
	public void setUp() {
		// set up before each test method 
	}

	@After
	public void tearDown() {
		// clean up after each test method 
	}

	@Test
	public void testFindAll() {
		
		List<Product> allProducts = productService.findAll();
		
		Assert.assertNotNull("expected to get a list of products", allProducts);
		Assert.assertTrue("expected the size of the list to be > 0", allProducts.size() > 0);
	}
	
	@Test
	public void testFindOne() {
		
		Long id = Long.valueOf(4444);
		Long validId = Long.valueOf(5555);
		Product product = productService.findOne(id);
		
		Assert.assertNull("expected null for id 4444", product);
		product = productService.findOne(validId);
		Assert.assertNotNull("expected to find a product with id 5555", product);
	}
	
	@Test
	public void testFindByCategory() {
		
		String category = "foo";
		String validCategory = "baby";
		List<Product> list = productService.findByCategory(category);
		
		Assert.assertTrue("expected to get an empty list on search for foo", list.size() == 0);
		list = productService.findByCategory(validCategory);
		Assert.assertNotNull("expected to get products in the list on search for baby", list);
		Assert.assertTrue("expected to get products in the list on search for baby", list.size() > 0);
		
	}
	
}