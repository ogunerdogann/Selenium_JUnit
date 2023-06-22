package day12_webTables_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {
        //bilgisayarimizda olan bir dosyaya erisebilmek icin
        //FileInputStream Class'indan obje olusturalim

        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/day12_webTables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //projemize ekledigimiz POI kutuphanelerini kullanarak
        //class'imizin icinde istenen excel'in bir kopyasini olusturalim.

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1"); // istedigimiz sayfaya gidiyoruz
        Row row = sheet.getRow(1); // index 0'dan basliyor
        Cell cell = row.getCell(3); // index 0'dan basliyor
        System.out.println(cell);

        //5. index'teki satirin 1. index'indeki datanin "Luanda" oldugunu test edin

        row = sheet.getRow(5);
        cell = row.getCell(1);

        String expectedData = "Luanda";

        //Cell objesinin data türü cell
        //Java'da farkli data türlerindeki variable'lari Equals ile KULLANAMAYIZ!
        Assert.assertEquals(expectedData,cell.toString());

        //12. Satir 2. sutundaki bilginin 'Baku' oldugunu test edin

       String actualData= sheet.getRow(11).getCell(1).toString();
       expectedData = "Baku";
       Assert.assertEquals(expectedData,actualData);
    }
}
