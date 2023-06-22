package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_TestBaseIlkClass extends TestBase {

    @Test
    public void test01(){

        // amazona gidelim
        driver.get("https://amazon.com");

        //nutella icin arama yapalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //arama sonuclarinin nutella icerdigini test edelim
        String expectedIcerik = "Nutella";
        String actualIcerik = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }
}
