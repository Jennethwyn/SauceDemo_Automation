package dataprovider;

import org.testng.annotations.DataProvider;

public class ProductDataProvider {

	
	@DataProvider(name = "Products", parallel = true)
	public Object[][] getProduct() {
		
		
		return new Object[][] {
			
		} ;
		
	}
	
}
