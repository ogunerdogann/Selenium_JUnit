package day06_JUnit_Framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {

    /*
         Bir Assertion failed olursa
         Assertion'un oldugu satirda exception olusur ve
         Assertion satirindan sonraki kodlar calismaz!
     */

    WebDriver driver; // Objemi class level'da olusturuyorum ki tüm testlerde rahatca kullanabileyim.
    @Test
    public void googleTestMethodu(){
        // 1- google anasayfasina gidip, url'nin google icerdigini test edin.
        mahserinDortAtlisi();
        driver.get("https://www.google.com");
        String expectedUrl = "google";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        driver.close();
    }
    @Test
    public void wiseTest(){
        // 2- wisequarter sayfasina gidip url'nin wisequarter icerdigini test edin.
        mahserinDortAtlisi();
        driver.get("https://www.wisequarter.com");
        String expectedUrl = "wisequarter";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        driver.close();
    }
    @Test
    public void amazonTest(){
        // 3- amazon anasayfasina gidip, amazon logosunun göründügünü test edin.
        mahserinDortAtlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.id("nav-logo-sprites"));
       Assert.assertTrue(amazonLogoElementi.isDisplayed());
        driver.close();
    }

    public void mahserinDortAtlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
