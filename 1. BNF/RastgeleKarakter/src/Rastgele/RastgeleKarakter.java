package Rastgele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
/**
 *
 * @author Kivircik
 */
public class RastgeleKarakter {   
long RastgeleSayımız;
public RastgeleKarakter(){              //Kurucu Fonksiyon
Date now = new Date();                  //Tarih nesnesini oluşturuyoruz
long RastgeleSayi = now.getTime();      //Timestamp değerini alıyoruz(1970'ten bu yana geçen saniye)
RastgeleSayımız = RastgeleSayi;
}
public int uret(){                  //Rastgele sayıyı üreten fonksiyon
    int rastgele = 0;               //Rastgele sayıyı tutacak değişken
        while(true){                //Sayı üretelene kadar dönecek
        Date now = new Date();                  //Tarih nesnesini oluşturuyoruz
        long RastgeleSayi = now.getTime();      //Timestamp değerini alıyoruz(1970'ten bu yana geçen saniye)
        RastgeleSayımız = RastgeleSayi;
        rastgele = (int) (RastgeleSayımız%123);  //Rastgelesayıyı 122 den küçük olacak şekilde modunu alıyoruz 
            if (rastgele>=0 && rastgele<97) {       //Küçük a Ascii tablosunda 97'dedir. Kontrol
                int fark = 97-rastgele;         
                rastgele = fark + rastgele + ((int) (RastgeleSayımız%20)); //Eğer sayı 97 den küçükse 97 ile 122 arasında bir değer gelmesi için 
                break;                                                      //Tekrar rastgelelik sağlanıyor
            }
            else
            {
                break;
            }
        }
    return rastgele; //Rastgele sayı döndürülüyor
}
public char karakterUret(){ //Rastgele harfi üreten fonksiyon
    char karakter = ' ';    //Rastgele gelen harfi tutan değişken
    int sayi = uret();      //Rastgele sayı alınıyor
    karakter = (char)sayi;  //Harfin ascii değerini harfe çeviriyoruz
    return karakter;        //Harf geri döndürülüyor
}
public char[] adetKarakter(int sayi){ //Belirli sayıda karakter üreten fonksiyon
    char a[]=new char[sayi];        //Harfleri tutacak dizi
    for (int i = 0; i < sayi; i++) {    //İstenen harf sayısı kadar dönen döngü
        a[i] = karakterUret();          //Karakter üreten fonksiyon çağırılıyor
    }
    return a;
}
public char aralikKarakter(char karakter, char karakter2){ //Belli harf aralığında karakter üreten fonksiyon
    char b;                     
    int sayi = (int)karakter;  //İstenen ilk karakterin ascii değeri
    int sayi2 = (int)karakter2;//İstenen ilk karakterin ascii değeri
        while(true){        //Karakterler o aralıkta üretilene kadar dönüyor
        int a = uret();     //Rastgele sayı alınıyor
        if(a<sayi){         //Sayı eğer istenen ilk harften küçükse girer
          a = a + (sayi-a) + (uret()%(sayi2-sayi)); //Sayı istenen sol baştaki harfe gelir ve yine rasgele aralıkta üretilir
              b = (char)a;      //Karakter atanır
            break;
        }
        else if(sayi2<a){       //Sayı eğer istenen ikinci harften büyükse girer
          a = a - (a-sayi2)-(uret()%(sayi2-sayi)); //Sayı aralığa girsin diye işlem yaptık
              b = (char)a;                         //Önce farkı düşürüp sonra yine iki harf arasında üretiyoruz
            break;
        }
        else if(sayi<a && sayi2<a)      //Eğer aralıktaysa girer
        {
            b=(char)a;    //Direk atanır
            break;
        }
        }   
    return b;
    }
public char[] adetAralik(int sayi, char Kar1, char Kar2){ //Belirli aralıkta istenen sayıda karakter üreten fonksiyon
    char b[] = new char[sayi];      //İstenen sayı büyüklüğünde dizi oluşuyor
    for (int i = 0; i < sayi; i++) {    //Sayı sayısı kadar döngü
        b[i] = aralikKarakter(Kar1,Kar2);       //Fonksiyon çağırılıyor
    } 
    return b;
    }
public char[] adetVerilen(String a, int b){ //Dışarıdan verilen karakterler arasından belli sayıda karakter veren fonksiyon
     char[] parca;
        parca = new char[a.length()];   //Karakter adedi kadar uzun dizi oluşuyor
        int[] z;
        z = new int[a.length()];        //Karakter adedi kadar uzun sayı dizisi
        parca = a.toCharArray();        //String olarak aldığımız karakterleri char dizisine döndürdük
        char[] m = new char[b];
        for (int i = 0; i < a.length(); i++) {
             z[i] = (int)parca[i];     //Karakterlerin ascii değerlerini diziye atadık
        }
        int j = 0;
        while(true){                    //Karakter eşleşmesi olana kadar döngü
        for (int i = 0; i < a.length(); i++) { 
           int o = uret()%a.length(); //Karakter adedi kadar rastgele sayı ürettik
           m[j] = parca[o];         //Atama yaptık
           if(j == b-1){            //İstenen adet bulunduysa çıkıyor
              return m;
           }
        }
         j++;
        }
    }
public char Verilen(String a){              //Verilen karakterler arasından bir tane karakter döndüren fonksiyon
        char[] parca = new char[a.length()];    //Karakter adedi büyüklüğünde dizi
        int[] z = new int[a.length()];          //Karakter adedi büyüklüğünde ascii değerleri tutacak dizi
        parca = a.toCharArray();                //Karakterleri parçalayıp diziye attık
        char m = 0;
        for (int i = 0; i < a.length(); i++) {
             z[i] = (int)parca[i];     //Karakterlerin ascii değerlerini diziye atadık
        }
       while(true){                 //Karakter döndürülene kadar döngü
            int c = uret();             //Sayı üretliliyor
//             System.out.println(c);
             for (int i = 0; i < a.length(); i++) {
                 if (c == z[i]) { //Karakter eşleşirse girecek
                m = (char)z[i]; //Atama yapılacak
                  return m;
             
            }
           }
          
        }
        
      
    }    
public char[] cumleGetir(){     //Rastgele Kelime ve cümle üreten fonksiyon
     char[] a;
     int maxkarakter= uret()%30;    //30 karakter üretecek
     a = new char[maxkarakter];     //Dizi oluşturuluyor
         for (int i = 0; i < maxkarakter-1; i++) {        
              a[i] = karakterUret();//Karakterler atanıyor
             if((i%6) == 3){ //Belirli aralıklarla boşluk atanıyor
                 a[i] = ' ';
             }          
         }
         a[maxkarakter-1]='.'; //Cümlenin sonuna nokta koyuluyor
         return a;
     }  
}

