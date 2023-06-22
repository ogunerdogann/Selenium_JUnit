package day10_actionsClass_Faker_FileTestleri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Waits {

    WebDriver driver;
    @Test
    public void test01() throws InterruptedException {
        // implicitly wait'in rolünü görebilmek icin
        // baslangic ayarlarini bu test methodunda yapalim

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
}
