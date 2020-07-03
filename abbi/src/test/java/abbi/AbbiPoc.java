package abbi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbbiPoc {

	public WebDriver driver;
	// Below line creates an object of Properties called 'prop'
	public static Properties prop;
	// Below line creates an object of FileInputStream called 'fi'. Give the path of
	// the properties file which you have created
	public static FileInputStream fi;
	@BeforeClass
	public static void setupClass() throws Exception {
		prop = new Properties();
		try {
			fi = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop.load(fi);
		WebDriverManager.chromedriver().version(prop.getProperty("chromeVersion")).setup();

	}

	@Before
	public void setupTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void test() throws Exception {
		driver.findElement(By.id("username")).sendKeys("Shailaja");
		driver.findElement(By.id("pwd")).sendKeys("june@123");
		driver.findElement(By.id("signInBut")).click();

		Thread.sleep(3000);

		try {
			WebElement popUp = driver.findElement(By.xpath("//button[@class='close js-close-btn']"));
			if (popUp.isDisplayed()) {
				popUp.click();
				System.out.println("popup clicked");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread.sleep(5000);

		try {
			WebElement popUp1 = driver
					.findElement(By.xpath("//span[@class='first-icon fui-checkbox-unchecked']"));
			if (popUp1.isDisplayed()) {
				// popUp1.click();
				Actions act = new Actions(driver);
				act.moveToElement(popUp1).click().perform();
				System.out.println("popUp1 clicked");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if (driver.getCurrentUrl().contains("test")) {

		}

		else {
			// driver.findElement(By.linkText("Edit")).isDisplayed();
			driver.findElement(By.linkText("Edit")).click();
		}	}

//    @Test
//	public  void loginTest() {
//
//		// setup the chromedriver using WebDriverManager
////	        WebDriverManager.chromedriver().setup();
//		WebDriverManager.chromedriver().version("83.0.4103.14").setup();
//		// Create driver object for Chrome
//		WebDriver driver = new ChromeDriver();
//
//		// Navigate to a URL
//		// driver.get("https://toolsqa.com");
//
//		// quit the browser
//		// driver.quit();
//
//		// System.setProperty("webdriver.chrome.driver",
//		// "C:\\Users\\P7112037\\Desktop\\AABI\\chromedriver.exe");
//		// driver = new ChromeDriver();
//
//		driver.get("https://dev.abbi.pearson.com/");
//
//		driver.manage().window().setSize(new Dimension(1048, 706));
//
//		driver.findElement(By.id("username")).sendKeys("greg19");
//
//		driver.findElement(By.id("pwd")).sendKeys("Abcd1234*");
//
//		driver.findElement(By.id("signInBut")).click();
//
//		driver.findElement(By.cssSelector(".program-dropdown")).click();
//
//		driver.findElement(By.cssSelector(".dropdown-regular > li:nth-child(3) .pull-left")).click();
//
//		driver.findElement(By.cssSelector("#subjectContextDropdown .caret")).click();
//
//		driver.findElement(By.cssSelector(".open li:nth-child(2) .pull-left")).click();
//
//		driver.findElement(By.cssSelector("#gradeContextDropdown .caret")).click();
//
//		driver.findElement(By.cssSelector(".open li:nth-child(6) .pull-left")).click();
//
//		driver.findElement(By.cssSelector("#logoutBtn > span")).click();
//
//		driver.close();
//
//	}

}
