package revirew;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ChromeVersion117 {
	
		
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\Chrome 117\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
		
		option.setBinary("C:\\Users\\Admin\\Downloads\\Chrome 117\\chrome-win64\\chrome.exe");
		
		ChromeDriver driver = new ChromeDriver(option);
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("Demosaesmanager");
	}
}