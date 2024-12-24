package CODES.JAVA;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class symb {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://d3pv22lioo8876.cloudfront.net/tiptop/");
		
		// Verify that the text input element with xpath .//input[@name='my-disabled']
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		boolean flag = driver.findElement(By.xpath("input[@name='my-disabled']")).isEnabled();
		System.out.println("My Button is enabled: " + flag);
		
//	    Verify that the text input with value 'Readonly input' is in readonly state by using 2 xpaths

		String a = driver.findElement(By.xpath("//input[@value='Readonly input']")).getAttribute("defaultValue");
		System.out.println("Text is " + a);

//	    Verify that the dropdown field to select color is having 8 elements using 2 xpaths

		Select b = new Select(driver.findElement(By.xpath("//select[@name='my-select']")));
		List<WebElement> count = b.getOptions();

		System.out.println("count is " + count.size());

//	    Verify that the submit button is disabled when no data is entered in Name field
		boolean flagg = driver.findElement(By.xpath("//input[@name='my-name']")).isEnabled();
		System.out.println("My Button is enabled: " + flagg);

//	    Verify that the submit button enabled when both Name and Password field is entered

		driver.findElement(By.xpath("//input[@name='my-name']")).sendKeys("sai");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ram");
		boolean flaggg = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
		System.out.println("My Button is enabled: " + flaggg);
//	    Verify that on submit of 'Submit' button the page shows 'Received' text

		driver.findElement(By.xpath("//input[@name='my-name']")).sendKeys("sai");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ram");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// p[text()='Received!']

		System.out.println(driver.findElement(By.xpath("//p[text()='Received!']")).getText());

//	    Verify that on submit of form all the data passed to the URL

		String strUrl = driver.getCurrentUrl();
		// Print the URL
		System.out.println(strUrl);

		Thread.sleep(1000);
		driver.quit();
	}
}
