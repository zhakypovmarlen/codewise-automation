package guru;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.AgileProjectPage;
import pages.GuruHomePage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class AgileProject {

    GuruHomePage guruHomePage = new GuruHomePage();
    AgileProjectPage agileProjectPage = new AgileProjectPage();

    @Before
    public void testSetup(){
        Driver.getDriver().get(Config.getValue("guruURL"));
    }


    @Test
    public void login(){
        Driver.getDriver().findElement(By.linkText("Agile Project")).click();

        String userID = Driver.getDriver().findElement(By.xpath("//ol/li[1]")).getText().substring(9);
        String password = Driver.getDriver().findElement(By.xpath("//ol/li[2]")).getText().substring(11);

        Driver.getDriver().findElement(By.name("uid")).sendKeys(userID);
        Driver.getDriver().findElement(By.name("password")).sendKeys(password + Keys.ENTER);

        String expectedURL = "https://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php";

        ApplicationFlow.pause(500);

        Assert.assertEquals("Login functionality failed" ,expectedURL,Driver.getDriver().getCurrentUrl());

    }

    @Test
    public void logout(){
        Driver.getDriver().findElement(By.linkText("Agile Project")).click();

        String userID = Driver.getDriver().findElement(By.xpath("//ol/li[1]")).getText().substring(9);
        String password = Driver.getDriver().findElement(By.xpath("//ol/li[2]")).getText().substring(11);

        Driver.getDriver().findElement(By.name("uid")).sendKeys(userID);
        Driver.getDriver().findElement(By.name("password")).sendKeys(password + Keys.ENTER);

        String expectedURL = "https://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php";

        ApplicationFlow.pause(500);

        Assert.assertEquals("Login functionality failed" ,expectedURL,Driver.getDriver().getCurrentUrl());

        Driver.getDriver().findElement(By.linkText("Log out")).click();

        Alert alert = Driver.getDriver().switchTo().alert();
        String expectedMessage = "You Have Succesfully Logged Out!!";
        Assert.assertEquals("Log out failed, Alert message is not same.", expectedMessage, alert.getText());
        alert.accept();

        String expectedLogoutURL = "https://demo.guru99.com/Agile_Project/Agi_V1/index.php";

        Assert.assertEquals("Log out failed ,URL is not same.", expectedLogoutURL, Driver.getDriver().getCurrentUrl());

    }

    @Test
    public void pomTest(){

        guruHomePage.agileProject.click();
        agileProjectPage.userIDInput.sendKeys(agileProjectPage.userID.getText().substring(9));
        agileProjectPage.passwordInput.sendKeys(agileProjectPage.password.getText().substring(11));
        agileProjectPage.loginButton.click();
    }

    @Test
    public void logoutPOM(){
        guruHomePage.agileProject.click();
        String userID = agileProjectPage.userID.getText().substring(9);
        String password = agileProjectPage.password.getText().substring(11);
        agileProjectPage.login(userID,password);
        agileProjectPage.logoutButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        String expectedMessage = "You Have Succesfully Logged Out!!";
        Assert.assertEquals("Alert message failed", expectedMessage, alert.getText());
        alert.accept();

    }

    @After
    public void cleanUp(){
        Driver.quit();
    }

}
