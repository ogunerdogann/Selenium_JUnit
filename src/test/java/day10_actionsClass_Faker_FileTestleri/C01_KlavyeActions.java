package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_KlavyeActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve
        //Enter’a basarak arama yaptirin
        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)  //Shift'e bastim (basili kaldi)
                .sendKeys("s")  //yaziyi yolladim
                .keyUp(Keys.SHIFT) // Shift'ten elimi cektim
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform(); // tüm islemleri yaptiktan sonra bir defa perform kullansan yeterli
        Thread.sleep(3000);
        //4- aramanin gerceklestigini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String expectedIcerik = "Samsung A71";
        String actualIcerik = sonucYaziElementi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        Thread.sleep(3000);
    }
}
