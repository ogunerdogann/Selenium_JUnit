package day11_SeleniumWaits_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_explicitlyWait extends TestBase {
    @Test
    public void test01(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textbox.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); //driver'i 40 sn beklet
        wait.until(ExpectedConditions.elementToBeClickable(textbox));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledElementi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnabledElementi.isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textbox.isEnabled());
    }
}
