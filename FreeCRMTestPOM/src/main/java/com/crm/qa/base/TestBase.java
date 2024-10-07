package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\2162910\\OneDrive - Cognizant\\Desktop\\POM\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			// if lenght of the path is long we can divide it
			prop.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initilization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("edge")) {
			System.setProperty("diver.edge.driver", "./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equals("chrome")) {
			System.setProperty("diver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(prop.getProperty("url"));

	}

}
