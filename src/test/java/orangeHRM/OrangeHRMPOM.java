package orangeHRM;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.OrangeHRMHomePage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class OrangeHRMPOM {

    private OrangeHRMHomePage orangeHRMHomePage = new OrangeHRMHomePage();

    @Before
    public void setup(){
        Driver.getDriver().get(Config.getValue("orangeHRMURL"));
    }

    @Test
    public void happyPathLogin(){
        orangeHRMHomePage.sendProperUsername();
        orangeHRMHomePage.sendProperPassword();
        orangeHRMHomePage.loginButton.click();
        Assert.assertEquals("Could not log in, URLs are different", orangeHRMHomePage.loggedInURL, Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void noUsernameLogin(){
        orangeHRMHomePage.sendProperPassword();
        orangeHRMHomePage.loginButton.click();
        ApplicationFlow.pause(1000);
        Assert.assertTrue("Required message was not present", orangeHRMHomePage.requiredMessageForUsername.isDisplayed());
        Assert.assertEquals("Logged in, URLs are different", orangeHRMHomePage.homePageURL, Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void noPasswordLogin(){
        orangeHRMHomePage.sendProperUsername();
        orangeHRMHomePage.loginButton.click();
        ApplicationFlow.pause(500);
        Assert.assertTrue("No message was shown", orangeHRMHomePage.requiredMessageForPassword.isDisplayed());
        Assert.assertEquals("Logged in, URLs are different", orangeHRMHomePage.homePageURL, Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void emptyCredentialsLogin(){
        orangeHRMHomePage.loginButton.click();
        ApplicationFlow.pause(1000);
        for(WebElement message : orangeHRMHomePage.requiredMessagesForBoth){
            Assert.assertTrue("No required messages were shown", message.isDisplayed());
        }
        Assert.assertEquals("Logged in, URLs are different", orangeHRMHomePage.homePageURL, Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void validateNumberOfButtons(){
        orangeHRMHomePage.sendProperUsername();
        orangeHRMHomePage.sendProperPassword();
        orangeHRMHomePage.loginButton.click();


    }

    @After
    public void cleanup(){
        Driver.quit();
    }

}
