package day14_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecuter extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //wisequarter ana sayfaya gidin
            driver.get("https://www.wisequarter.com");

        //asagiya inerek Software Development Engineer in Test - SDET
        //kursunda explore the course butonuna basin
        WebElement exploreButonu= driver.findElement(By.xpath(("(//a[@class='elementskit-btn whitespace--normal'])[2]")));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //jse ile butona kadar scroll yapalim
        jse.executeScript("arguments[0].scrollIntoView();",exploreButonu);

        //jse ile click yapalim
        jse.executeScript("arguments[0].click();",exploreButonu);

        //jse ile alert olusturma
        jse.executeScript("alert('Bu is bu kadar!');");
        Thread.sleep(3000);
    }
}
