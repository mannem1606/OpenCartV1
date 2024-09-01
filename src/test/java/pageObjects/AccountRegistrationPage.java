package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;

	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;


	@FindBy(xpath="//input[@name='agree']")
	WebElement ChkPolicy;

	@FindBy(xpath="//input[@value='Continue']")
	WebElement BtnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		 Email.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String psw) {
		txtPassword.sendKeys(psw);
	}
	
	public void setConfirmPassword(String psw) {
		txtConfirmPassword.sendKeys(psw);
	}
	
	public void setPrivacyPolicy() {
		ChkPolicy.click();
	}
	
	
	
	public void clickContinue() {
		// Sol 1
		BtnContinue.click();
		
		// Sol 2
		//BtnContinue.submit();
		
		// Sol 3
		//Actions act=new Actions(driver);
		//act.moveToElement(Btncontinue).click().perform();
		
		// Sol 4
		//JavaScriptExecutor js=(JavaScriptExecutor)driver;
		//js.executeScript("arguments[0].click();",btnContinue);
		
		// Sol 5
		//btnContinue.sendKeys(keys.RETURN);
		
		//sol 6
		//WebElement mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//myWait.until(ExpectedConditions.elementToBeClickable(BtnContinue)).click();
		
	}

   public String getConfirmationMsg() {
	   try {
		   return (msgConfirmation.getText());
	   }catch (Exception e) {
		   return (e.getMessage());
	   
	   }
   }
} 
