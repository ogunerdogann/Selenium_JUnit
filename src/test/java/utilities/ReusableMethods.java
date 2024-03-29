package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReusableMethods {
    public static void tumSayfaFotografCek(WebDriver driver) {

        TakesScreenshot tss = (TakesScreenshot) driver;

        LocalDateTime ldt= LocalDateTime.now();
        String tarihEtiketi = "Tum Sayfa"+ldt.getYear()+ldt.getMonth()+ldt.getDayOfMonth()
                +ldt.getHour()+ldt.getMinute()+ldt.getSecond()+".png";
        String path = "target/ekranResimleri/"+tarihEtiketi;
        File tumSayfaFotograf = new File(path);
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciResim,tumSayfaFotograf);
        } catch (IOException e) {
        }
    }

    public static void webElementFotografCek(WebDriver driver, WebElement webElement) {
        LocalDateTime ldt= LocalDateTime.now();
        String tarihEtiketi = "WebElement"+ldt.getYear()+ldt.getMonth()+ldt.getDayOfMonth()
                +ldt.getHour()+ldt.getMinute()+ldt.getSecond()+".png";
        String path = "target/ekranResimleri/"+tarihEtiketi;
        File tumSayfaFotograf = new File(path);
        File geciciResim = webElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciResim,tumSayfaFotograf);
        } catch (IOException e) {
        }
    }
}
