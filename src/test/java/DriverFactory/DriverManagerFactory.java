package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(DriverType type){
        DriverManager manager;

        switch (type){
            case CHROME :
                WebDriverManager.chromedriver().setup();
                manager = new ChromeDriverManager();
                break;
//            case FIREFOX:
//                WebDriverManager.firefoxdriver().setup();
//                manager = new FirefoxDriverManager();
//                break;
            default:
                manager = null;
        }

        return manager;
    }
}
