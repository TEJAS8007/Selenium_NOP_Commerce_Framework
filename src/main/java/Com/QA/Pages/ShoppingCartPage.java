package Com.QA.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {

	WebDriver driver;
	
	By ProductInCart=By.cssSelector("table[class='cart'] tbody .product-picture");
	
	By ProductName=By.cssSelector("a.product-name");
	
	By GiftWrapping=By.cssSelector("select#checkout_attribute_1"); //Yes [+$10.00]
	
	By TotalTable=By.cssSelector("table.cart-total tr");
	
	By checkbox=By.id("termsofservice");
	
	By CheckoutButton=By.cssSelector("button#checkout");
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String Verify_Shopping_Cart_Title() {
		return driver.getTitle();
	}
	
	public String Verify_Shopping_Cart_url() {
		return driver.getCurrentUrl();
	}
	
	public boolean Verify_Shopping_Cart_product_InCart() {
		boolean found;
		
		if(driver.findElement(ProductInCart).isDisplayed()==true) {
			found=true;
		}
		else {
			found=false;
		}
		return found;
	}
	
	public String Verify_shoping_cart_Product_Name() {
		return driver.findElement(ProductName).getText();
	}
	
	public void Verify_shopping_Cart_Gift_Wrapping() {
		
		List<WebElement> gifts= driver.findElements(GiftWrapping);
		
		for(int a=0;a<gifts.size();a++) {
			
			if(gifts.get(a).getText().equals("Yes [+$10.00]")) {
				driver.findElements(GiftWrapping).get(a).click();
			}
		}
	}
	
	public void Verify_shopping_Cart_Total_table() {
		
		for(int a=0;a<driver.findElements(TotalTable).size();a++) {
			String text= driver.findElements(TotalTable).get(a).getText();
			System.out.println(text);
		}
	}
	
	public void Click_on_Checkout() {
		driver.findElement(checkbox).click();
		driver.findElement(CheckoutButton).click();
	}
}
