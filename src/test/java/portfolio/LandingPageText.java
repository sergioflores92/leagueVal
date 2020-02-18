package portfolio;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObejcts.LandingPage;
import resources.Base;

public class LandingPageText extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());


	@BeforeTest
	public void startDriver() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void inspectLandingPage() {
		
		LandingPage lp = new LandingPage(driver);
		
		Assert.assertEquals(lp.getH2Text().getText(), "CONVIÉRTETE EN LEYENDA");
		log.info("Succesfully validated H2 text message");

		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
}
