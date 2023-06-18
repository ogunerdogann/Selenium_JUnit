package day06_JUnit_Framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {

    /*
       Bu class icerisinde 3 test calistiralim:
       1- google anasayfasina gidip, url'nin google icerdigini test edin.
       2- wisequarter sayfasina gidip url'nin wisequarter icerdigini test edin.
       3- amazon anasayfasina gidip, amazon logosunun göründügünü test edin.
     */

    /*
       JUnit'in bize sagladigi ilk ve belki en önemli özellik test methodlarinin
       bagimsiz olarak calistirilabilmesini saglayan @Test Notasyonudur.

       Junit ile class level'dan birden fazla test methodu calistirirsak
       hangi siralama ile calistirilacagini öngöremeyiz ve yönetemeyiz.

       Diyelim ki bir test methodu üzerinde calisiyorsunuz ve o methodun
       toplu calistirilmalarda calistirilmasini istemiyorsunuz.
       Bu durumda @Test'in yanina @Ignore yazarak o testi gecersiz kilabilirsiniz.
     */
    WebDriver driver; // Objemi class level'da olusturuyorum ki tüm testlerde rahatca kullanabileyim.
    @Test
    public void googleTestMethodu(){
       // 1- google anasayfasina gidip, url'nin google icerdigini test edin.
        mahserinDortAtlisi();
        driver.get("https://www.google.com");
        String expectedUrl = "google";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("URL testi basarili!");
        }
        else System.out.println("URL testi basarisiz!");
        driver.close();
    }
    @Test @Ignore
    public void wiseTest(){
       // 2- wisequarter sayfasina gidip url'nin wisequarter icerdigini test edin.
        mahserinDortAtlisi();
        driver.get("https://www.wisequarter.com");
        String expectedUrl = "wisequarter";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("URL testi basarili!");
        }
        else System.out.println("URL testi basarisiz!");
        driver.close();
    }
    @Test
    public void amazonTest(){
       // 3- amazon anasayfasina gidip, amazon logosunun göründügünü test edin.
        mahserinDortAtlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.id("nav-logo-sprites"));
        if (amazonLogoElementi.isDisplayed()){
            System.out.println("Logo Testi basarili!");
        }
        else System.out.println("Logo Testi basarisiz!");
        driver.close();
    }

    public void mahserinDortAtlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
