package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_iframe extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //konsolda yazdirin.
        WebElement iFrameYaziElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iFrameYaziElementi.isDisplayed());
        System.out.println(iFrameYaziElementi.getText());

        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement frameElementi = driver.findElement(By.id("mce_0_ifr")); //textBox element bir iframe'in icinde o nedenle önce iframe'e ulasmamiz gerekir!
        driver.switchTo().frame(frameElementi);

        WebElement textBoxElementi = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dünya! :)");
        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin.

        /*
        iframe'e gecis yapilinca driver'i oradan cikis yaptirana kadar
        driver iframe'in icinde kalir.

        driver.switchTo().parentFrame : ic ice birden fazla frame varsa, bir üste cikar
        driver.switchTo().defaultContent() : direk anasayfaya cikar
         */
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumLinki = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSeleniumLinki.isDisplayed());
        System.out.println(elementalSeleniumLinki.getText());
        Thread.sleep(3000);
    }
}
