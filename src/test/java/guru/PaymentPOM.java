package guru;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.GuruHomePage;
import pages.PaymentGatewayPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class PaymentPOM {

    PaymentGatewayPage paymentGatewayPage = new PaymentGatewayPage();

    GuruHomePage guruHomePage = new GuruHomePage();

    @Before
    public void setup(){
        Driver.getDriver().get(Config.getValue("guruURL"));
    }

    @Test
    public void purchase(){
        guruHomePage.paymentProjectLink.click();
        paymentGatewayPage.buyNowButton.click();
        paymentGatewayPage.cardNumberInput.sendKeys("1234567891234567");
        paymentGatewayPage.selectMonth("05");
        paymentGatewayPage.selectYear("2019");
        paymentGatewayPage.cvvInput.sendKeys("564");
        ApplicationFlow.pause(1000);
        paymentGatewayPage.payButton.click();
        String orderID = paymentGatewayPage.orderIDNumber.getText();
        String expectedURL = "https://demo.guru99.com/payment-gateway/genearte_orderid.php?uid=" + orderID;
        Assert.assertEquals("Buy functionality failed", expectedURL, Driver.getDriver().getCurrentUrl());
    }

    @After
    public void cleanup(){
        Driver.quit();
    }
}
