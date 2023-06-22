package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_DosyaYolunuDinamikYapma {
    @Test
    public void test01(){
         /*
           Herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan  herkesin
           dosyasi birbirinden farkli olur. Dosya youlunu dinamik hale getirmek
           icin JAVA'dan yardim almamiz gerekir.
         */
        System.out.println(System.getProperty("user.dir"));
        //projenin dosya yolunu verir
        //C:\Users\ogune\OneDrive\Desktop\BOOTCAMP\JUnit\com.Team113JUnit
        System.out.println(System.getProperty("user.home")); //C:\Users\ogune

        /*
           Biz downloads'a indirdigimiz dosya yolunu ikiye bölecegiz
              C:\Users\ogune                                    \\Downloads\sample.png
          herkesin bilgisayarinda farkli                           herkeste ayni
          System.getPropertiy("user.home")                      \\Downloads\sample.png
         */

        String dosyaYoluDegisenKisim = System.getProperty("user.home");
        String DosyaYoluHerkesteAyniOlanKisim = "\\Downloads\\sample.png";

        String dosyaYolu = dosyaYoluDegisenKisim+DosyaYoluHerkesteAyniOlanKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //ayni islemi projemzin altindaki deneme.txt icin yapsak
        //src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt
       dosyaYoluDegisenKisim = System.getProperty("user.dir");
       DosyaYoluHerkesteAyniOlanKisim = "/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";
        dosyaYolu = dosyaYoluDegisenKisim+DosyaYoluHerkesteAyniOlanKisim;
       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
