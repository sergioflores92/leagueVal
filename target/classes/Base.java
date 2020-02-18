package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;


public class Base {
	public  WebDriver driver;
	public Properties prop;
	public  Logger log = LogManager.getLogger(Base.class.getName());
	String path;


	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		
		path = System.getProperty("user.dir");
		path = path.replace("\\", "\\\\");
		log.info(path);
		
		FileInputStream fis = new FileInputStream(path+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		String browserName = System.getProperty("browser");
		log.info("Succesfully selected "+browserName+" browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\java\\resources\\chromedriver.exe");
			
			driver = new ChromeDriver();
			log.info(browserName+" browser created");
			
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",path+"\\src\\main\\java\\resources\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("headless");
			
			driver = new FirefoxDriver(options);
			log.info(browserName+" browser created");

		}else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",path+"\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.info(browserName+" browser created");


		}else {
			System.out.println("Edge");
			log.info(browserName+" browser created");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void getScreenShot(String test) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(path+test+"_screenshot.png"));
	}
}
