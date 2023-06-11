package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class OrangeHRMHomePage {

    public String homePageURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public String loggedInURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";


    public OrangeHRMHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "username")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "(//p[1])[1]")
    public WebElement username;

    @FindBy(xpath = "(//p[2])[1]")
    public WebElement password;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@name='username']/../../span")
    public WebElement requiredMessageForUsername;

    @FindBy(xpath = "//input[@name='password']/../../span")
    public WebElement requiredMessageForPassword;

    @FindBy(xpath = "(//span[.='Required'])")
    public List<WebElement> requiredMessagesForBoth;

    public void sendProperUsername(){
        String username1 = username.getText().substring(11);
        usernameInput.sendKeys(username1);
    }

    public void sendProperPassword(){
         String password1 = password.getText().substring(11);
         passwordInput.sendKeys(password1);
    }



}
