package guru;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import utilities.Config;
import utilities.Driver;

public class PaymentGateway {

    @Before
    public void testSetup(){
        Driver.getDriver().get(Config.getValue("guruURL"));
    }

    @After
    public void cleanup(){
        Driver.quit();
    }
    @Test
    public void itemPurchase(){


        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();


        String testCardNumber = "4067034071588587";
        String testCVV = "706";
        String testMonth = "05";
        String testYear = "2026";


        Driver.getDriver().findElement(By.id("card_nmuber")).sendKeys(testCardNumber);

        Select select = new Select(Driver.getDriver().findElement(By.id("month")));
        select.selectByVisibleText(testMonth);


        Select select1 = new Select(Driver.getDriver().findElement(By.id("year")));
        select1.selectByVisibleText(testYear);

        Driver.getDriver().findElement(By.id("cvv_code")).sendKeys(testCVV);
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();

        String actualResult = Driver.getDriver().findElement(By.xpath("//h2")).getText();

        Assert.assertTrue(actualResult.contains("successfull"));

    }

    @Test
    public void balance(){

        String testCardNumber = "4067034071588587";
        String testCVV = "706";
        String testMonth = "05";
        String testYear = "2026";

        Driver.getDriver().findElement(By.linkText("Check Credit Card Limit")).click();

        Driver.getDriver().findElement(By.id("card_nmuber")).sendKeys(testCardNumber + Keys.ENTER);

        int balance = Integer.parseInt(Driver.getDriver().findElement(By.xpath("//h4/span")).getText());

        Driver.getDriver().findElement(By.linkText("Cart")).click();
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        Driver.getDriver().findElement(By.id("card_nmuber")).sendKeys(testCardNumber);

        Select select = new Select(Driver.getDriver().findElement(By.id("month")));
        select.selectByVisibleText(testMonth);


        Select select1 = new Select(Driver.getDriver().findElement(By.id("year")));
        select1.selectByVisibleText(testYear);

        Driver.getDriver().findElement(By.id("cvv_code")).sendKeys(testCVV);
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();

        Driver.getDriver().findElement(By.linkText("Check Credit Card Limit")).click();
        Driver.getDriver().findElement(By.id("card_nmuber")).sendKeys(testCardNumber + Keys.ENTER);

        int actualBalance = Integer.parseInt(Driver.getDriver().findElement(By.xpath("//h4/span")).getText());

        Assert.assertEquals(actualBalance, balance - 20);
    }
}
