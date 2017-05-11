package myretail.web;

import myretail.AbstractTest;

import org.junit.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
public class ProductControllerTest extends AbstractTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
    	
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();
        
    }

    @Test
    public void testGetProducts() throws Exception {
    	
	 mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
	 
    }


	@Test
    public void testGetProduct() throws Exception {
		
 	mockMvc.perform(get("/products/5555"))
 		.andExpect(status().isOk());
 	
    }	
    
    @Test
    public void testGetProductsByCategory() throws Exception {
    	
    	mockMvc.perform(get("/products/filter?category=toys"))
		.andExpect(status().isOk());
    	
   }

}
