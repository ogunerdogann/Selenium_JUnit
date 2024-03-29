package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_NewWindow extends TestBase {
    /*
       Eger driver.switchTo().newWindow kullanilirsa driver otomatik olarak
       acilan yeni sayfaya gecer.

       Eger görevimizde yeni window'a gittikten sonra window'lar arasi gecis islemi varsa
       üstünde calistigimiz window'larin windowHandle degerlerini alip kaydetmekte fayda var.
     */
    @Test
    public void test01(){

        //gerekli ayarlamalari yapip
        //amazon anasayfaya gidin.
        driver.get("https://amazon.com");
        String ilkSayfaWHD = driver.getWindowHandle();

        //title'in Amazon kelimesi icerdigini test edin.
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //yeni bir tab acarak wisequarter anasayfaya gidin.
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String ikinciSayfaWHD = driver.getWindowHandle();

        //url'nin wisequarter icerdigini test edin
        String expectedUrl = "wisequarter";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //tekrar amazon'un acik oldugu ana sayfaya gecin
        //ve URL'nin amazon icerdigini test edin.
        driver.switchTo().window(ilkSayfaWHD);
        expectedUrl = "amazon";
        actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

}
