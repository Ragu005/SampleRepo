package revirew;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ChromeVersion115 {
	
	public static ChromeDriver driver;
	public static String browserPath;

	@BeforeSuite
	public void beforeSuite() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		//To get the current  Browser version
		String browserVersion = driver.getCapabilities().getBrowserVersion();	
		String browserName = driver.getCapabilities().getBrowserName();
		System.out.println(browserVersion);
		System.out.println(browserName);
		
		//Launch the url to download the latest browser version
		
		driver.get("https:/edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/"+browserVersion+"/win32/chrome-win32.zip");
		
		//
		Thread.sleep(30000);
			
		//Path where CFT zip file is downlaoded
		String downloadPath = System.getProperty("user.home") + "\\Downloads";
		System.out.println("The download path is --------"+ downloadPath);
		String CTFZipPath = downloadPath+"/chrome-win32.zip";
		
		/* Add commons-compress maven dependency in pom.xml to unzip the downloaded folder
		 * <dependency>
          <groupId>org.apache.commons</groupId>
          <artifactId>commons-compress</artifactId>
          <version>1.23.0</version>
         </dependency>
		 */	
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(CTFZipPath));
		ZipEntry zipEntry = zipInputStream.getNextEntry();
		
		//output is chrome-win32/115.0.5790.110.manifest
		
		String name = zipEntry.getName();
		System.out.println(name);
		//replace the same (chrome-win32/115.0.5790.110.manifest) with exe file name i.e -chrome.exe and which is the browser path for CTF
		
		browserPath = name.replaceAll(browserVersion+".manifest", browserName+".exe");
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@BeforeMethod
	public void setUp() {

		ChromeOptions opt=new ChromeOptions();
		//Add the CTF browser path as Chrome options
		opt.addArguments("--start-maximized");
		opt.setBinary(browserPath);
		driver =new ChromeDriver(opt);
		driver.get("http://leaftaps.com/opentaps");



	}

	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(3000);;
	}


	@AfterMethod
	public void tearDown() {
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


		
//	public static void main(String[] args) {
//
//		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\Chrome 117\\chromedriver-win64\\chromedriver.exe");
//		
//		WebDriverManager.chromedriver().driverVersion("115.0.5790.110").setup();
//		
//		System.out.println(System.getProperty("webdriver.chrome.driver"));
//		
//		ChromeOptions option = new ChromeOptions();
//		
//		option.setBinary("C:\\Users\\Admin\\Downloads\\Chrome 115\\chrome-win64\\chrome.exe");
//		
//		ChromeDriver driver = new ChromeDriver(option);
//		
//		driver.get("http://leaftaps.com/opentaps/control/main");
//		
//		driver.manage().window().maximize();
//		
//		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
//		
//		
//	}
}