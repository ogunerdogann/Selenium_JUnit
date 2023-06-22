package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class C02_JSAlerts extends TestBaseBeforeClass{

    /*
     Otomasyon yaüparken iki tür alert ile karsilasabiliriz;
     1- HTML Alerts
     HTML kodlari ile olusturulmus alert'lerdir. HTML ile olusturuldugu icin
     inspect edilebilir, locate edilebilir ve driver ile kullanilabilir.

     2- JavaScript Alerts
     Inspect yapilamaz, locate edilemez
     Testlerimiz sirasinda JS alert ile karsilasirsak
     driver.switchTo().alert() methodlarini kullanarak alert'e gecis
     yapabilir ve alert üzerinde OK, Cancel, Alert yazisini alma getText()
     ve alert'e yazi yollama sendKeys() method'larini kullanabiliriz
     */

    //3 test method'u olusturup asagidaki gorevi tamamlayin
    //1. Test
    @Test
    public void test01() throws InterruptedException {

        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(3000);
        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedYazi = "I am a JS Alert";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(actualYazi,expectedYazi);

        //- OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }

    //2.Test
    @Test
    public void test02() throws InterruptedException {

        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
          driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);
        //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        String expectedSonuc="You clicked: Cancel";
        String actualSonuc = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualSonuc,expectedSonuc);
    }

    //3.Test
    @Test
    public void test03() throws InterruptedException {

        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        //- Cikan prompt ekranina "Timur" yazdiralim
        driver.switchTo().alert().sendKeys("Timur");
        Thread.sleep(3000);
        //- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //- Cikan sonuc yazisinin Timur icerdigini test edelim
        String expectedSonuc = "Timur";
        String actualSonuc = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

    }

}
