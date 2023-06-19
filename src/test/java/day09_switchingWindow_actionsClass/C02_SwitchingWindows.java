package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C02_SwitchingWindows extends TestBase {
    /*
       driver.switchTo.newWindow() kullanarak actigimiz window'a driver otomatik olarak gecer.

       ANCAKKKK!!
       biz newWindow() method'unu kullanmadan bir link'e tikladigimizda yeni window aciliyorsa
       driver eski window'da kalir.
       Yeni window'a driver'i gecirebilmek icin yeni driver'in windowHandle degerine
       ihtiyacimiz vardir.

     */
    @Test
    public void test01() throws InterruptedException {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWHD = driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText = "Opening a new window";
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(actualText.equals(expectedText));

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
        //43. Satir itibariyle yeni window acildi, artik 2 window var.
        Set<String> whdDegerleriSet = driver.getWindowHandles();
        String ikinciSayfaWHD ="";
        for (String eachWHD: whdDegerleriSet
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD = eachWHD;
            }
        }

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            driver.switchTo().window(ikinciSayfaWHD);
            expectedTitle = "New Window";
            actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle,expectedTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
            expectedText ="New Window";
            actualText = driver.findElement(By.tagName("h3")).getText();
            Assert.assertEquals(actualText,expectedText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
