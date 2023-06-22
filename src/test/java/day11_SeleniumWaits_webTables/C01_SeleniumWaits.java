package day11_SeleniumWaits_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_SeleniumWaits {
    /*
        Otomasyon yaparken sayfanin yüklenmesi ve WebElementlerin bulunmasi icin
        gerekli süreyi implicitly wait ile ayarlariz.

        Implicitly wait sayfanin yüklenmesi ve her bir web elementin bulunmasi icin
        tnimlanan max. bekleme süresidir.
        Her islem icin sifirdan baslar ve max süre doluncaya kadar görevi tamamlamaya calisir.
        max süre icerisinde görev tamamlanamazsa exception verip calismayi durdurur.

        Testlerin büyük cogunlgunda implicitly wait süresi senkronizasyonu saglamak icin
        yeterli olur
        ANCAK!
        özel bir görev icin implicitly wait'de tanimlanan max bekleme süresinden daha
        fazla beklmemiz gerekirse O GÖREVE ÖZGÜ, TEK SEFERLIK bir bekleme (wait) olusturabiliriz.

     */
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin



    @Test
    public void test01() throws InterruptedException {
        // implicitly wait'in rolünü görebilmek icin
        // baslangic ayarlarini bu test methodunda yapalim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement mesaj = driver.findElement(By.id("message"));
        Assert.assertTrue(mesaj.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement mesaj2 = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));

        Assert.assertTrue(mesaj2.isDisplayed());
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void explicitlyWaitTesti() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        /*
           Burada testi manuel olarak yapip
           bir karar vermemiz gerekiyor
           1-test etmek istedigimiz webelement zaten görünüyorsa webelement'i locate edip
             sonra özel beklemeyi tanimlarim
           2- test etmek istedigimiz elementin ulasilabilir olmasi icin beklmemk gerekiyorsa
           locator'i verip "bu locator ile bir element locate edene kadar exception firlatma bekle" diyebiliriz.
         */
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        WebElement itsGoneElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        // xpath'i (yukaridaki gibi) olan element locate edilip görünür oluncaya kadar bekle
        Assert.assertTrue(itsGoneElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackElementi.isDisplayed());
        driver.close();
    }
}
