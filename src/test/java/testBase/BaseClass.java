package testBase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;


import org.testng.annotations.Parameters;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class BaseClass {
public static WebDriver driver;
public Logger logger;  // Log4j
public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master","Datadriven"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		//Loading config.properties
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);		
		
		logger=LogManager.getLogger(this.getClass());
		
		// Execution environment in remote
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//OS
			if(os.equalsIgnoreCase("windows")) 
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{ 
				System.out.println("No matching OS");
				return;
			}
			
			//browser
			switch(br.toLowerCase()) 
			{
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox": capabilities.setBrowserName("firefox");break;
			default: System.out.println("No matching browser"); return;
			}
			driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		
		// Execution environment in the Local
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch (br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver();break;
			case "edge" : driver=new EdgeDriver();break;
			case "firefox" : driver=new FirefoxDriver();break;
			default:System.out.println("Invalid Browser name...");return;
			}
		}
		
	     // ***** For Local environment execution ***** 
		/*switch (br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver();break;
		case "edge" : driver=new EdgeDriver();break;
		case "firefox" : driver=new FirefoxDriver();break;
		default:System.out.println("Invalid Browser name...");return;
		}*/
		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://demo-opencart.com/");
		driver.get(p.getProperty("appURL")); // Reading URL from properties
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	
	public String randomString() {
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
		
	}
	
	public String randomNumber() {
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
		
	}
     
	public String randomAlphaNumeric() {
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatednumber);
	}
	
	public String captureScreen(String tname) throws IOException{
		
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp;
		File targetFile=new File(targetFilePath);	
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		
	
	}

}
