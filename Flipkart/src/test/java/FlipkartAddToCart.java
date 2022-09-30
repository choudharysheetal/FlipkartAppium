import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.BaseClass;
import Utility.IConstants;
import objectRepoitory.Flipkart;

public class FlipkartAddToCart extends BaseClass{
@Test
public void flipkartAddToCart() {
	String productName = excelUtility.getDataFromExcel("flipkart", 1, 1);
	System.out.println("Product Name :"+productName);
	Flipkart flipcart=new Flipkart();
	flipcart.clickSearch();
	flipcart.productName(productName);
	flipcart.clickParticularProductName();
	String expectedProductName = flipcart.getProductName();
	System.out.println(expectedProductName);
	flipcart.clickOnAddToCart();
	//flipcart.clickOnSkipBtn();
	flipcart.clickOnGoToCart();
	String actualProductName = flipcart.getMyCartProductName(expectedProductName);
	System.out.println(actualProductName);
	Assert.assertEquals(expectedProductName, actualProductName);
	
	
}
}
