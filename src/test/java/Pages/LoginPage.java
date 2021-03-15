package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, String url) {
        super(driver, url);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "userName")
    private WebElement userNameInput;

    @FindBy(name = "password")
    private WebElement passWord;

    @FindBy(css = "#login_form > div:nth-child(5) > button")
    private WebElement loginButton;

    @FindBy(xpath="//div[3]/div/button")
    private WebElement loginErrorClose;
    
    @FindBy(xpath="//div[3]/div[2]/button")
    private WebElement loginErrorClose1;
    
    public void waitLoginPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
       // driver.wait(500);
    }


    public void navigateToLoginPage() {
        driver.get(url);
    }

    public void setUserName(String userName) {
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
        userNameInput.clear();
        userNameInput.sendKeys(userName);
    }

    public void setPassWord(String password) {
        passWord.clear();
        passWord.sendKeys(password);
    }

    public void clickOnLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void clickOnFirstLoginErrorCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginErrorClose)).click();
    }
    public void clickOnSecondLoginErrorCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginErrorClose1)).click();
    }
}
