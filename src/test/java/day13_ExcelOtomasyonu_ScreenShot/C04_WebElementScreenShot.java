package day13_ExcelOtomasyonu_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_WebElementScreenShot extends TestBase {
    @Test
    public void test01(){

        //amazon sayfasina gidelim
        driver.get("https://www.amazon.com/");

        // Nutella aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edelim
        WebElement sonucElementi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualSonucYazisi = sonucElementi.getText();
        String expectedIcerik = "Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // rapora eklenmek üzere sonuc elementinin screeenshot'unu alalim
        ReusableMethods.webElementFotografCek(driver,sonucElementi);
    }
}
