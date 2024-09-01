package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement LinkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement LinkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement LinkLogin;
	
	public void clickMyAccount() {
		LinkMyAccount.click();
		
	}
	
	public void clickRegister() {
		
		LinkRegister.click();
	}
	
    public void clickLogin() {
		
		LinkLogin.click();
	}

	

}
