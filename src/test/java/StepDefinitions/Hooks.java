package StepDefinitions;

import java.nio.file.Path;
import java.awt.AWTException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import DriverFactory.DriverManagerFactory;
import DriverFactory.DriverType;
import Pages.HomePage;
import Pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import videoRecorder.VideoRecorder;

import org.monte.media.math.Rational;
import org.monte.media.Format;
import org.monte.screenrecorder.ScreenRecorder;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;
public class Hooks extends Model{
	 @Before
	    public void testInit() throws IOException, AWTException  {
	        driver = DriverManagerFactory.getDriverManager(DriverType.CHROME).getDriver();
	        homePage = new HomePage(driver, "https://test.thepromoapp.com/#!/");
	        loginPage = new LoginPage(driver, "https://test.thepromoapp.com/#!/login");
	        recorder=new VideoRecorder();
	        recorder.startRecording(driver);
	    }
	    @After
	    public void closingBrowser(Scenario scenario) throws IOException {

	    	recorder.stopRecording(scenario);
	    	
//if(scenario.isFailed()) {
//	
//	
//	scenario.attach(bytes, "video/mp4", "zip_video_file");
//}
  		  
//	    	if(scenario.isFailed()) {


//		            final byte[] screenshot = ((TakesScreenshot) driver)
//                    .getScreenshotAs(OutputType.BYTES);
//		            scenario.attach(screenshot,"image/png", "name");
//	    		  }
	    	driver.close();
	    }
	    
//	    @BeforeTest
//	    public void beforetest() throws ATUTestRecorderException {
//	    	
//	    }
//	    
//	    @AfterTest
//	    public void aftertest() throws ATUTestRecorderException {
//	    	
//	    }
	    @AfterStep
	    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

	            final byte[] screenshot = ((TakesScreenshot) driver)
	                    .getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot,"image/png", "name");
	        	
        	
	            driver.close();
	        }
       
	        }

	    

	    @Given("Navigate to main page")
	    public void navigate_to_main_page() {
	        homePage.getUrl();
	        //Assert.assertEquals("Log In", homePage.getHomePageLoginButton().getText());
	    }
	    
	    @Given("Navigate to login page")
	    public void navigate_to_login_page()  {
	    	
	    	loginPage.navigateToLoginPage();
	    	
	    }
	    
		@When("I press the login button")
		public void i_press_the_login_button() {
			loginPage.clickOnLoginButton();
		}
}
