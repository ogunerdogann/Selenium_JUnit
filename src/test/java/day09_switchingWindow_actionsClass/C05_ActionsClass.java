package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_ActionsClass extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        //3- “Neue Liste anlegen ” butonuna basin
        Actions actions = new Actions(driver);
        WebElement accountsListMenu = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        actions.moveToElement(accountsListMenu).perform();
        WebElement createListElementi = driver.findElement(By.xpath("//*[text()='Neue Liste anlegen ']"));
        createListElementi.click();

        //4- Acilan sayfada “Meine Listen” yazisi oldugunu test edin
        WebElement yourListElementi = driver.findElement(By.xpath("//div[@role='heading']"));
        String expectedYazi = "Meine Listen";
        String actualYazi = yourListElementi.getText();
        Assert.assertEquals(actualYazi,expectedYazi);
        Thread.sleep(3000);
    }
}
