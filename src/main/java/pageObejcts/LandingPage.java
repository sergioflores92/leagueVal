package pageObejcts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private  By continueBtn = By.cssSelector(".continue");
	private  By leyenda = By.xpath("//h2[contains(text(),'leyenda')]");

	public WebElement getContinuePage() {
		return driver.findElement(continueBtn);
	}
	
	public WebElement getH2Text() {
		return driver.findElement(leyenda);
	}
}
