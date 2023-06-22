package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.LocalTime;
import java.util.Set;

public class C03_ActionsClass extends TestBase {

    @Test
    public void test01() throws InterruptedException {

    //    //x sn'lik bir sayac yapalim
    //    int x =3;
    //    LocalTime baslangic = LocalTime.now();
    //    int baslangicSaniyesi = baslangic.getSecond();
    //    int saniyeKontrol = 123;
//
    //    int bitisSaniyesi = baslangicSaniyesi+x > 60 ? baslangicSaniyesi+x-60 : baslangicSaniyesi+x;
//
    //    while (bitisSaniyesi !=saniyeKontrol){
    //        saniyeKontrol=LocalTime.now().getSecond();
    //    }
    //    System.out.println(baslangicSaniyesi);
    //    System.out.println(bitisSaniyesi);
  //**************************************************************************************

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        /*
         Linki tikladigimizda yeni window acildigindan tiklamadan önce ilk window'un
         WHD degerini almamiz gerekir.
         */
        String ilkWindowWHD = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //ikinci sayfa biz new window demeden acildigindan ikinci window'un
        //WHDNdegerini Java kullanarak bulmaliyiz.
        String ikinciWindowWHD ="";
        Set<String> windowDegerleriSeti = driver.getWindowHandles(); // icinde iki tane WHD var.
        //ilkWindowWHD'e esit olmayani ikinciWindowWHD olarak atayalim.
        for (String eachWHD:windowDegerleriSeti
             ) {
            if (!eachWHD.equals(ilkWindowWHD)){
                ikinciWindowWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciWindowWHD);
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String expectedYazi = "Elemental Selenium";
        WebElement yaziElementi = driver.findElement(By.tagName("h1"));
        String actualYazi = yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        Thread.sleep(3000);
    }
}
