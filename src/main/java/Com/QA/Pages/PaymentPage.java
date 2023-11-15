package Com.QA.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {

	WebDriver driver;
	
	By ShippingMethods=By.cssSelector("ul.method-list li div");
	
	By ShippingContinue=By.cssSelector("button[class='button-1 shipping-method-next-step-button']");
	
	By PaymentMethods=By.cssSelector("ul#payment-method-block li div.payment-details");
	
	By PaymentContinue=By.xpath("//button[@class='button-1 payment-method-next-step-button']");
	
	By PayementInformation=By.cssSelector("div.info td p");
	
	By PaymentInfoContinue=By.xpath("//button[@class='button-1 payment-info-next-step-button']");
	
	By BillingAddress=By.cssSelector("div.billing-info ul li");
	
	By ShipingAddress=By.cssSelector("div.shipping-info ul li");
	
	By FinalTotalBox=By.cssSelector("table.cart-total tr");
	
	By ConfirmOrderContinue=By.xpath("//button[@class='button-1 confirm-order-next-step-button']");
	
	By OrderNumber=By.cssSelector("div.details div strong");
	
	By OrderConfirmationMessage=By.cssSelector("div[class='section order-completed'] .title strong");
	
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String Verify_Payment_Page_Title() {
		return driver.getTitle();
	}
	
	public String Verify_Payment_Page_Url() {
		return driver.getCurrentUrl();
	}
	
	public List<WebElement> Verify_Payment_Page_shipping_Methods() {
		return driver.findElements(ShippingMethods);
	}
	
	public void Click_On_Shipping_Continue() {
		driver.findElement(ShippingContinue).click();
	}
	
	public List<WebElement> Verify_Payement_Page_Payments_Methods() {
		return driver.findElements(PaymentMethods);
	}
	
	public void Click_on_Payment_Continue() {
		driver.findElement(PaymentContinue).click();
	}
	
	public int Verify_Payment_Page_Payment_information() {
		
		int count=0;
		
		List<WebElement> payInfoList= driver.findElements(PayementInformation);
		
		for(int a=0;a<payInfoList.size();a++) {
			String text=payInfoList.get(a).getText();
			System.out.println(text);
			count++;
		}
		System.out.println("Payment information count : "+count);
		driver.findElement(PaymentInfoContinue).click();
		return count;
	}
	
	public int Verify_Payment_Page_Billing_Address() {
		int count=0;
		
		List<WebElement> billinginfolist= driver.findElements(BillingAddress);
		
		for(int a=0;a<billinginfolist.size();a++) {
			String text= billinginfolist.get(a).getText();
			System.out.println(text);
			count++;
		}
		System.out.println("Billing Info count : "+count);
		return count;
	}
	
	public int Verify_Payment_Page_Shipping_Address() {
		int count=0;
		
		List<WebElement> shippinginfoList= driver.findElements(ShipingAddress);
		
		for(int a=0;a<shippinginfoList.size();a++) {
			String text= shippinginfoList.get(a).getText();
			System.out.println(text);
			count++;
		}
		System.out.println("Shipping Address count : "+count);
		return count;
	}
	
	public void Verify_PayMent_Page_Final_Table() {
		List<WebElement> finallist= driver.findElements(FinalTotalBox);
		
		for(int a=0;a<finallist.size();a++) {
			String text= finallist.get(a).getText();
			System.out.println(text);
		}
		driver.findElement(ConfirmOrderContinue).click();
	}
	
	public String Verify_Order_Number() {
		System.out.println(driver.findElement(OrderConfirmationMessage).getText());
		return driver.findElement(OrderNumber).getText();
	}
	
	public String Returning_Order_Number() {
		return driver.findElement(OrderNumber).getText();
	}
}
