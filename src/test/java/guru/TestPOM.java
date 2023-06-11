package guru;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pages.AgileProjectPage;
import pages.GuruHomePage;
import utilities.Config;
import utilities.Driver;

public class TestPOM {

    GuruHomePage guruHomePage = new GuruHomePage();
    AgileProjectPage agileProjectPage = new AgileProjectPage();



    @Test
    public void menuTest(){
        Driver.getDriver().get(Config.getValue("guruURL"));
        guruHomePage.agileProject.click();
        agileProjectPage.userIDInput.sendKeys(agileProjectPage.userID.getText().substring(9));
        agileProjectPage.passwordInput.sendKeys(agileProjectPage.password.getText().substring(11));
        agileProjectPage.loginButton.click();
    }
    @Before
    public void setup(){
        Driver.getDriver().get(Config.getValue("guruURL"));

    }
}
