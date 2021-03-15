package DriverFactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;

    protected abstract void createDriver();

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }


    public void quiteDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
