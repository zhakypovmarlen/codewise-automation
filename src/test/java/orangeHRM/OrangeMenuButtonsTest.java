package orangeHRM;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.OrangeHRMHomePage;
import pages.OrangeMainPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class OrangeMenuButtonsTest {

    private OrangeMainPage orangeMainPage = new OrangeMainPage();
    private OrangeHRMHomePage orangeHRMHomePage = new OrangeHRMHomePage();

    @Before
    public void setup(){
        Driver.getDriver().get(Config.getValue("orangeHRMURL"));
    }
    @After
    public void cleanup(){
        Driver.quit();
    }

    @Test
    public void checkNumberOfMenuBtn(){
        orangeHRMHomePage.sendProperUsername();
        orangeHRMHomePage.sendProperPassword();
        orangeHRMHomePage.loginButton.click();
        Assert.assertEquals(orangeMainPage.menuButtons.size(), 11);
    }

    @Test
    public void buttonsFunctionality(){
        orangeHRMHomePage.sendProperUsername();
        orangeHRMHomePage.sendProperPassword();
        orangeHRMHomePage.loginButton.click();
        ApplicationFlow.pause(1000);
        for(int i = 0; i < orangeMainPage.menuButtons.size(); i++){
            System.out.println(i);
            String oldUrl = Driver.getDriver().getCurrentUrl();
            System.out.println("old " + oldUrl);
            orangeMainPage.menuButtons.get(i).click();
            String newUrl = Driver.getDriver().getCurrentUrl();
            System.out.println("new " + newUrl);
            if(i == 9){
                Driver.getDriver().findElement(By.xpath("//button[@type='button']")).click();
                continue;
            }
            Assert.assertNotEquals("Button is not clickable", oldUrl, newUrl);
            ApplicationFlow.pause(1000);
        }
    }
}
