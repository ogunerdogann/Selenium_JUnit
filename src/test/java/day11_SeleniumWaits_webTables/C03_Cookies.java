package day11_SeleniumWaits_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet =  driver.manage().getCookies();
        int siraNo = 1;
        for (Cookie eachCookie: cookiesSet
             ) {
            System.out.println(siraNo+"----"+eachCookie);
            siraNo++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedMinCookieSayisi=5;
        int actualCookieSayisi = cookiesSet.size();
        Assert.assertTrue(actualCookieSayisi>expectedMinCookieSayisi);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie eklenecekCookie = new Cookie("en sevdigim Cookie","cikolatali");
        driver.manage().addCookie(eklenecekCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
         cookiesSet =  driver.manage().getCookies();
         siraNo = 1;
         String enSevdigimCookieValue = "";
        for (Cookie eachCookie: cookiesSet
        ) {
            System.out.println(siraNo+"----"+eachCookie);
            if (eachCookie.getName().equals("en sevdigim Cookie")){
                enSevdigimCookieValue= eachCookie.getValue();       //en sevdigim cookie'nin value degerini aliyoruz
            }
            siraNo++;
        }
        expectedCookieValue = "cikolatali";
        Assert.assertEquals(expectedCookieValue,enSevdigimCookieValue);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookiesSet =  driver.manage().getCookies();
        siraNo = 1;
        String flag = "skin isminde bir cookie yok";
        for (Cookie eachCookie: cookiesSet
        ) {
            System.out.println(siraNo+"----"+eachCookie);
            if (eachCookie.getName().equals("skin")){
                flag="skin isminde flag bulundu";
            }
            siraNo++;
        }
        Assert.assertTrue(flag.equals("skin isminde bir cookie yok"));
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet =  driver.manage().getCookies();
        Assert.assertEquals(cookiesSet.size(),0);
    }
}
