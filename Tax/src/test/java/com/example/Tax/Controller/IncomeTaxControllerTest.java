package com.example.Tax.Controller;


	import com.example.Tax.Service.IncomeTaxService;
import com.example.Tax.controller.IncomeTaxController;
import com.example.Tax.model.IncomeTax;
	import com.fasterxml.jackson.databind.ObjectMapper;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.MockitoAnnotations;
	import org.springframework.http.MediaType;
	import org.springframework.http.ResponseEntity;
	import org.springframework.test.web.servlet.MockMvc;
	import org.springframework.test.web.servlet.MvcResult;
	import org.springframework.test.web.servlet.setup.MockMvcBuilders;

	import java.util.ArrayList;
	import java.util.List;

	import static org.mockito.ArgumentMatchers.any;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;
	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

	public class IncomeTaxControllerTest {

	    private MockMvc mockMvc;

	    @Mock
	    private IncomeTaxService taxService;

	    @InjectMocks
	    private IncomeTaxController incomeTaxController;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(incomeTaxController).build();
	    }

	    @Test
	    public void testGetAllIncomes() throws Exception {
	        // Prepare mock data
	        List<IncomeTax> incomes = new ArrayList<>();
	        // Add some incomes to the list

	        // Mock the service method
	        when(taxService.getAllIncomes()).thenReturn(incomes);

	        // Perform the GET request and assert the response
	        mockMvc.perform(get("/api/getAll"))
	                .andExpect(status().isOk())
	                
	                // Add more assertions as needed
	                .andReturn();
	    }

	    @Test
	    public void testGetIncomeById() throws Exception {
	        // Prepare mock data
	        Long id = 1L;
	        IncomeTax income = new IncomeTax();
	        // Set properties for the income object

	        // Mock the service method
	        when(taxService.getIncomeById(id)).thenReturn(income);

	        // Perform the GET request and assert the response
	        mockMvc.perform(get("/api/getid/{id}", id))
	                .andExpect(status().isOk())
	               
	                // Add more assertions as needed
	                .andReturn();
	    }

	    @Test
	    public void testCreateIncome() throws Exception {
	        // Prepare mock data
	        IncomeTax income = new IncomeTax();
	        // Set properties for the income object

	        // Mock the service method
	        when(taxService.createIncome(any(IncomeTax.class))).thenReturn(income);

	        // Perform the POST request and assert the response
	        mockMvc.perform(post("/api/income")
	                
	                .content(new ObjectMapper().writeValueAsString(income)))
	                .andExpect(status().isOk())
	              
	                // Add more assertions as needed
	                .andReturn();
	    }

	    @Test
	   
	    public void testUpdateIncome() throws Exception {
	        // Prepare mock data
	        Long id = 1L;
	        IncomeTax incomeDetails = new IncomeTax();
	        // Set properties for the incomeDetails object

	        // Mock the service method
	        when(taxService.updateIncome(id, incomeDetails)).thenReturn(incomeDetails);

	        // Perform the PUT request and assert the response
	        mockMvc.perform(put("/api/{id}", id)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(new ObjectMapper().writeValueAsString(incomeDetails)))
	                .andExpect(status().isOk())
	                // Add more assertions as needed
	                .andReturn();
	    }

	    

	    @Test
	    public void testDeleteIncome() throws Exception {
	        // Prepare mock data
	        Long id = 1L;

	        // Perform the DELETE request and assert the response
	        mockMvc.perform(delete("/api/delete/{id}", id))
	                .andExpect(status().isOk())
	                // Add more assertions as needed
	                .andReturn();
	    }

	    @Test
	    public void testCalculateTax() throws Exception {
	        // Prepare mock data
	        IncomeTax income = new IncomeTax();
	        // Set properties for the income object

	        // Mock the service method
	        when(taxService.calculateTax(income)).thenReturn(income);

	        // Perform the POST request and assert the response
	        mockMvc.perform(post("/api/tax")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(new ObjectMapper().writeValueAsString(income)))
	                .andExpect(status().isOk())
	               
	                // Add more assertions as needed
	                .andReturn();
	    }
	}


