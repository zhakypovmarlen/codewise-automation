package sauce_demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.SauceDemoPage;
import utilities.Config;
import utilities.Driver;

public class POMTest {

    SauceDemoPage sauceDemoPage = new SauceDemoPage();

    @Before
    public void startup(){
        Driver.getDriver().get(Config.getValue("sauceDemoURL"));
    }
    @After
    public void cleanup(){
        Driver.quit();
    }

    @Test
    public void test1(){
        sauceDemoPage.usernameInput.sendKeys(sauceDemoPage.username);
        sauceDemoPage.passwordInput.sendKeys(sauceDemoPage.password);
        sauceDemoPage.loginButton.click();


    }
}
