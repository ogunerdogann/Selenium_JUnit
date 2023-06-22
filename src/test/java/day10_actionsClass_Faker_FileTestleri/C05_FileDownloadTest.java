package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDownloadTest extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. sample.png dosyasını indirelim
       WebElement sampleElementi= driver.findElement(By.linkText("sample.png"));
       sampleElementi.click();
       Thread.sleep(3000);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        // dosyayi download klasörüne indirecek
        String dosyaYolu = "C:\\Users\\ogune\\Downloads\\sample.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
           Herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan  herkesin
           dosyasi birbirinden farkli olur. Dosya youlunu dinamik hale getirmek
           icin JAVA'dan yardim almamiz gerekir.
         */
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
    }
}
