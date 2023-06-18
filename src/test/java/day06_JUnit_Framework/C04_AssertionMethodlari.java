package day06_JUnit_Framework;

import org.junit.Assert;
import org.junit.Test;

public class C04_AssertionMethodlari {

    @Test
    public void test01(){
        /*
        Eger testin sonucunu türkce olarak olumlu bir cümle ile sorduysa assertTrue
        olumsuz cümle kullanilmissa
         */
        int sayi1 = 20;
        int sayi2 = 10;
        int sayi3 = 30;

        // sayi1'in sayi2'den büyük oldugunu test edin.
        Assert.assertTrue(sayi1<sayi2);        //PASSED

        //sayi1'in sayi3'den büyük olmadigini test edin
        Assert.assertFalse(sayi1>sayi3);       //PASSED

        //sayi1'in sayi3'den kücük oldugunu test edin
        Assert.assertTrue(sayi1<sayi3);        //PASSED
    }
}
