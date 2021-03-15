package DriverFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
	  protected void createDriver() {
	        ChromeOptions options = new ChromeOptions();
	        //options.addArguments("--start-maximized");
	        this.driver = new ChromeDriver(options);
	    }
}
