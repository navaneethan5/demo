package myretail.repository;

import java.util.*;

import myretail.AbstractTest;
import myretail.domain.Product;
import myretail.repository.ProductRepository;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductRepositoryTest extends AbstractTest {
	
	@Autowired
    ProductRepository productRepository;

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
		
		List<Product> allProducts = productRepository.findAll();
		
		Assert.assertNotNull("expected to get a list of products", allProducts);
		Assert.assertTrue("expected the size of the list to be > 0", allProducts.size()>0);
		
	}
        
	@Test
	public void testFindOne() {
			
		Long id = Long.valueOf(5555);
		Product product = productRepository.findOne(id);
		
		Assert.assertNotNull("expected to find a product with id 5555", product);
		Assert.assertEquals("expected id attribute match", id, product.getId());
		
	}
        
	@Test
	public void testFindByCategory() {
		
		String category = "foo";
		String validCategory = "baby";
		List<Product> list = productRepository.findByCategory(category);
		
		Assert.assertTrue("expected to get an empty list on search for foo", list.size() == 0);
		list = productRepository.findByCategory(validCategory);
		Assert.assertTrue("expected to get products in the list on search for baby", list.size() > 0);
		
	}

}