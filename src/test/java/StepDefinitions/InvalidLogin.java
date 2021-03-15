package StepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvalidLogin extends Model{

	@Then("^Enter invalid ([^\"]*)$")
	public void enter_invalid_email(String email)  {
		
		loginPage.setUserName(email);
	}
	@And("^Entered invalid ([^\"]*)$")
	public void entered_invalid_pasword(String password) {
		loginPage.setPassWord(password);
	}


	@Then("Error message is shown")
	public void error_message_is_shown() {
		loginPage.clickOnFirstLoginErrorCloseButton();
		loginPage.clickOnSecondLoginErrorCloseButton();
	}

}
