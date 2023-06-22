package day12_webTables_excelOtomasyon;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    @Test
    public void test01(){
        //(//div[@role='row'])[4]/div[@role='gridcell'][2]
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> basliklarList = driver.findElements(By.xpath("//div[@role='columnheader']"));
        for (WebElement eachHeader: basliklarList
             ) {
            System.out.println(eachHeader.getText());
        }

        //3. 3.sutunun basligini yazdirin
        System.out.println("3. Sütun Basligi"+basliklarList.get(3).getText());

        //4. Tablodaki tum datalari yazdirin
        List<WebElement> tabloDatalari = driver.findElements(By.xpath("//div[@role='gridcell']"));
        int bosOlmayanDataSayisi=0;
        for (WebElement eachData:tabloDatalari
             ) {
            if (!eachData.getText().isBlank()){
                System.out.println(eachData.getText());
                bosOlmayanDataSayisi++;
            }
        }
        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("Tabloda Bos Olmayan Hücre Sayisi: "+bosOlmayanDataSayisi);

        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarList = driver.findElements(By.xpath("div[@role='rowgroup']"));
        System.out.println("Tablodaki Satir Sayisi: "+ satirlarList.size());

        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayisi: "+basliklarList.size());

        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuKolon = driver.findElements(By.xpath("(//div[@role='row'])/div[3]"));
        System.out.println("----- 3. Sutun -----");
        for (WebElement eachData: ucuncuKolon
             ) {
            System.out.println(eachData.getText());
        }

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        WebElement kierraSalary = driver.findElement(By.xpath("(//div[@role='row'])[4]/div[@role='gridcell'][5]"));
        System.out.println(kierraSalary.getText());

        //10. bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin
        dataYazdir(2,4);
    }
    public void dataYazdir(int satirNo, int sutunNo){
        String dinamikXPath = "(//div[@role='row'])["+satirNo+"]/div[@role='gridcell']["+sutunNo+"]";
        WebElement dataSatirSutun = driver.findElement(By.xpath(dinamikXPath));
        System.out.println("Istenen hücredeki Data: "+dataSatirSutun.getText());
    }
}
