package portfolio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObejcts.LanMenuPage;
import pageObejcts.LandingPage;
import pageObejcts.LoginPage;
import resources.Base;

public class SignProcess extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	
	@BeforeTest
	public void startDriver() throws IOException {
		driver = initializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		LanMenuPage lmp = new LanMenuPage(driver);
		LoginPage lp = new LoginPage(driver);

		//to get pass the landing page
		l.getContinuePage().click();
		log.info("clicked on continue button");
		
		
		//to get pass the first menu page
		lmp.getIniciarSesion().click();
		
		
		//to introduce a new username and password
		

		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		log.info("Test username: "+username+" password: "+password);
		

		lp.getIniciarBtn().click();
		
	}
	
	@DataProvider
	public Object[][] getData(){
		//this data provider passes the data to test
		//at the time passes to diferent usernames and their passwords
		Object[][] data =  {{"Matameromas","123456"},
							{"MiniLicwxyz","997068"}};
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;

	}
}
