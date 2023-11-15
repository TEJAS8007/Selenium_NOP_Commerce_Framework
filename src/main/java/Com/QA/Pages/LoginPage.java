package Com.QA.Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.QA.Factory.DriverFactory;

public class LoginPage {

    WebDriver driver;
	
	By loginLink =By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
	
	By emailBox=By.cssSelector("input.email");
	
	By passwordBox=By.cssSelector("input.password");
	
	By loginButton=By.cssSelector("button[class='button-1 login-button']");
	
	By pageTexts=By.cssSelector("div.page-title");
	
	By loginInfo=By.cssSelector("div.text");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void Click_on_Login_Button() {
		WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(20));
		wb.until
		         (ExpectedConditions
		        		 .elementToBeClickable(loginLink))
		                    .click();
	}
	
	public String Verify_Login_Page_Title() {
		return driver.getTitle();
	}
	
	public String Verify_Login_Page_Url() {
		return driver.getCurrentUrl();
	}
	
	public boolean Verify_Login_Page_Text() {
		boolean found;
		
		if(driver.findElement(pageTexts).isDisplayed()==true) {
			found=true;
			
			if(found==true) {
				String text= driver.findElement(pageTexts).getText();
				System.out.println(text);
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public boolean Verify_Login_Page_Info() {
		boolean found;
		
		if(driver.findElement(loginInfo).isDisplayed()==true) {
			found=true;
			
			if(found==true) {
				String text= driver.findElement(loginInfo).getText();
			    System.out.println(text);
			}
		}
		else {
			found=false;
		}
		return found;
	}
	
	public void Perform_Login_Action() {
		driver.findElement(emailBox).sendKeys(RegisterPage.email);
		driver.findElement(passwordBox).sendKeys(RegisterPage.pass);
		driver.findElement(loginButton).click();
	}
}
