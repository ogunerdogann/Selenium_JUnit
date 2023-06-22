package day10_actionsClass_Faker_FileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_FakerClass extends TestBase {

    /*
       Faker kütüphanesi fake degerler olusturabilecegimiz bir kütüphanedir.
       Buradan deger üretebilmek icin
       Faker class'indan bir obje olusturmaliyiz.
     */
    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        //Thread.sleep(158000);
        //2- Yeni hesap olustur butonuna basalim
        WebElement hesapOlusturButonu = driver.findElement(By.xpath("//a[@ajaxify='/reg/spotlight/']"));
        hesapOlusturButonu.click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isim = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        actions.click(isim)
                .sendKeys(faker.name().firstName())
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys("26")
                .sendKeys(Keys.TAB).sendKeys("Okt.")
                .sendKeys(Keys.TAB).sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB);
        Thread.sleep(5000);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(10000);
    }
}
