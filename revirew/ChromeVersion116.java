package revirew;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeVersion116 {
	
		
	public static void main(String[] args) {

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\Chrome 117\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
		
		//option.setBinary("117");
		option.setBrowserVersion("117");
		
//	WebDriverManager.chromedriver().driverVersion("115.0.05790.102").setup();
		
		ChromeDriver driver = new ChromeDriver(option);
		
		//EdgeDriver driver= new EdgeDriver();
		
	//	FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
	//	driver.findElement(By.id("username")).sendKeys("Demosaesmanager");
	}
}