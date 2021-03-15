package StepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidLogin extends Model {
	@Then("^Enter valid ([^\"]*)$")
	public void enter_valid_email(String email)  {
		
		loginPage.setUserName(email);
		
	}
	@And("^Entered valid ([^\"]*)$")
	public void enter_valid_pasword(String password) {
		
		loginPage.setPassWord(password);
		
	}
	

	@Then("I am redirected to the home page")
	public void redirected_to_home_page()  {
		homePage.pageVerification();
		
	}

}
