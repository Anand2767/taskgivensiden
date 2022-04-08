package org.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommanUtility {
	public static WebDriver driver;

	public static WebDriver ChromeLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public static void UrlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void back() {
		driver.navigate().back();
	}

	// 9 send keys
	public static void sendKeys(WebElement e, String data) {
		e.sendKeys(data);
	}

	public static void SelectByIndex(WebElement i, int index) {
		Select s = new Select(i);
		s.selectByIndex(index);

	}

	public static void implicitWait(long se) {
		driver.manage().timeouts().implicitlyWait(se, TimeUnit.SECONDS);

	}

	public static void click(WebElement e) {
		e.click();
	}

	public static void quit() {
		driver.quit();
	}
}
