package first.webapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductRegistratioTest {
	
	private ProductRegistration pr = new ProductRegistration();
	private Product p1;
	private Product p2;
	private Product p3;
	private Product p4;
	
	private final int SIZE = 4;
	private final int LIMIT = 4;  
	//if you want to run once per class - > like creating a database connection or start up of server then you might want to annotate with at before all
	
	@BeforeEach
	void setUp() throws Exception {
		pr = new ProductRegistration();
		p1 = new Product("0001","rice","thailand",22.90);
		p2 = new Product("0002","oil","malaysia",20.50);
		p3 = new Product("0003","milk","japan",5.95);
		p4 = new Product("0004","egg","poland",3.30);
		
		
		pr.addProduct(p1);
		pr.addProduct(p2);
		pr.addProduct(p3);
		pr.addProduct(p4);
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testProductRegistration() {
		System.out.println("@Test: testProductrRegistration");
	    assertTrue(true);  // try true and false
	}

	@Test
	void testProductRegistrationInt() {
		System.out.println("@Test: testProductrRegistrationInt");
		assertTrue(true);  // try true and false
	}

	@Test
	void testGetProducts() {
		List<Product> testPR = pr.getProducts();
		//Assert that the Song Collection is not empty after invoking getSongs function 
		assertFalse(testPR.isEmpty());
		// assert that Song collection size contains the correct number of songs inside
		assertEquals(testPR.size(),SIZE);
	}

	@Test
	void testAddProduct() {
		List<Product> testPR = pr.getProducts();
		//Assert that Song collection is equals to song collection size 4
		assertEquals(testPR.size(), SIZE);
		//Act - Add song function to add 1 additional song
		pr.addProduct(p1);
		// Assert that Song Collection is equals to song collection size 4 + 1
		// We assert that the initial song collection size is now 5
		assertEquals(pr.getProducts().size(), SIZE);
		//means "a passed parameter must not be null": if it is null then the test case fails.
		assertNotNull(p1);
		//Assert that Song Collection cannot be more than 5 (max capacity) 
		assertEquals(pr.getProducts().size(),LIMIT);
	}

	@Test
	void testSortProductsByName() {
		//Act 
		List<Product> testPR = pr.sortProductsByName();
		
		//Arrange 
		String newProductName1 = testPR.get(0).getName();
		String newProductName2 =  testPR.get(1).getName();
		String newProductName3 =  testPR.get(2).getName();
		String newProductName4 =  testPR.get(3).getName();
					
		//Assert that the Song list sorted from [A-Z] [a-z]
		assertEquals("rice", newProductName1);
		assertEquals("oil", newProductName2);
		assertEquals("milk", newProductName3);
		assertEquals("egg", newProductName4);
	}


	@Test
	void testSortProductsByPrice() {
		//Act 
		List<Product> testPR = pr.sortProductsByPrice();
			
		//arrange 
		double newPrice1 = testPR.get(0).getPrice();
		double newPrice2 = testPR.get(1).getPrice();
		double newPrice3 = testPR.get(2).getPrice();
		double newPrice4 = testPR.get(3).getPrice();
				
		//Assert that the the song list is sorted from largest to shortest song length 
		assertTrue(Double.compare(newPrice1, newPrice2) > 0);
		assertTrue(Double.compare(newPrice2, newPrice3) > 0 );
		assertTrue(Double.compare(newPrice3, newPrice4) > 0);
			
	}

	@Test
	void testFindProdcutsById() {
		//Act 
		Product validId = pr.findProdcutsById("0003");
		Product invalidId = pr.findProdcutsById("Invalid id");
						
		//assert we retrieve a valid song 
		assertNotNull(validId);
		//assert retrieve the accurate song based on Id 
		assertEquals("0003", validId.getId());
		//assert if we input invalid id : we get a null 
		assertNull(invalidId);
	}

	@Test
	void testFindProductByName() {
		Product validProduct = pr.findProductByName("milk");
		Product invalidProduct = pr.findProductByName("Invalid Product Name");
			
		//assert we retrieve a valid song 
		assertNotNull(validProduct);
		//assert retrieve the accurate song based on Id 
		assertEquals("0003", validProduct.getId());
		//assert if we input invalid id : we get a null 
		assertNull(invalidProduct);
	}

}
