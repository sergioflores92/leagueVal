package portfolio;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObejcts.LanMenuPage;
import pageObejcts.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void startDriver() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateNavigationBar() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		LanMenuPage lmp = new LanMenuPage(driver);
		
		lp.getContinuePage().click();
		log.info("clicked on continue button");

		if(!lmp.getRiotBarNavBar().isDisplayed()) {
			log.debug("Riot Nav bar didn't dispalyed");
		}
		Assert.assertTrue(lmp.getRiotBarNavBar().isDisplayed());
		log.info("Riot nav-bar is Displayed");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;

	}
}
