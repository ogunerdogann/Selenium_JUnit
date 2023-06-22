package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUPloadTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        /*
           driver ile gittigimiz bir web sayfasinda
           bilgisayarimizdaki bir dosyayi upload etmek istrsek bilgisayarimizdaki
           klasörlere erismemiz gerekir.
           Selenium WebDriver bilgisayardaki dosyalara erisemez.
           Bunun yerine su 3 adimda islemlerimizi yapariz
           1- choose file butonunu locate edelim
           2- bilgisayarimizdan yüklemek istedigimiz dosyanin dosya yolunu olusturalim
                 (Mümkünse dinamik olsun)
           3-chooseButonu.sendKeys(dosya yolu) ile dosya yolunu sisteme tanitalim
         */
//**************************************************************************************************
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonunu kullanarak deneme.txt'yi secelim
        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));
        String dosyaYoluHerkesteAyni = "/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";
        String dosyaYoluHerkesteFarkli = System.getProperty("user.dir");
        String dosyaYolu = dosyaYoluHerkesteFarkli+dosyaYoluHerkesteAyni;
        System.out.println(dosyaYolu);
        chooseFileButonu.sendKeys(dosyaYolu);

        //4. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //5. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement text = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(text.isDisplayed());
        Thread.sleep(5000);
    }
}
