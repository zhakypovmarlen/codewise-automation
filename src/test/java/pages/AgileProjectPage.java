package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AgileProjectPage {

    public AgileProjectPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ol/li[1]")
    public WebElement userID;
    // substring from 9 to get the userID


    @FindBy(xpath = "//ol/li[2]")
    public WebElement password;
    // substring from 11 to get the password

    @FindBy(name = "uid")
    public WebElement userIDInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(name = "btnLogin")
    public WebElement loginButton;

    @FindBy(name = "btnReset")
    public WebElement resetButton;

    @FindBy(linkText = "Log out")
    public WebElement logoutButton;

    public void login(String userID, String password){
        userIDInput.sendKeys(userID);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


}
