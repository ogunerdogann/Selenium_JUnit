package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_BasicAuthentication extends TestBase {
    //1- Bir class olusturun : BasicAuthentication
    @Test
    public void test01() throws InterruptedException {

        //2- https://the-internet.herokuapp.com/basic_auth
        //sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        // Html komutu : https://username:password@URL
        //Username : admin
        //password : admin
        //4- Basarili sekilde sayfaya girildigini dogrulayin

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement congratYaziElementi = driver.findElement(By.tagName("p"));
        Assert.assertTrue(congratYaziElementi.isDisplayed());
        Thread.sleep(3000);
    }

}
