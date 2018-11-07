/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdp4;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Lenovo
 */
public class Pdp4 {
 
     public static void main(String[] args) throws InterruptedException, IOException {
         long OkunanDeger;
         
         Scanner al = new Scanner(System.in);
         System.out.print("Faktöriyeli istenen sayı: ");
         OkunanDeger = al.nextLong();

        
        int AralikDeger = 1;
        
         if (OkunanDeger>99999){
             AralikDeger = 200;
         }
         else if (OkunanDeger>49999) {
             AralikDeger = 150;
         }
         else if (OkunanDeger>19999) {
             AralikDeger = 100; 
         }
         else if (OkunanDeger>9998) {
              AralikDeger = 50;
         }
         else if (OkunanDeger>999) {
              AralikDeger = 25;
         }
        
        int ThreadSayisi = (int)OkunanDeger/AralikDeger;
        Sayi deger1 = new Sayi(OkunanDeger);
        ExecutorService havuz = Executors.newFixedThreadPool((int) ThreadSayisi);
        Sayi deger2 = new Sayi(OkunanDeger);
        Runnable seri = new Faktoriyel(deger2, 1,AralikDeger); 
        Thread ornek1 = new Thread(seri);  
      
        long baslangic = System.nanoTime();   
        havuz.execute(new Faktoriyel(deger1,1,AralikDeger));      
        havuz.shutdown();
            while(!havuz.isTerminated()){  } 
        long bitis = System.nanoTime();//hesaplama bitiyor             
        double sure = (bitis-baslangic)/1000000.0; 
              
    
      
        long baslangic2; //hesaplama başlıyor 
        baslangic2 = System.nanoTime();
        ornek1.run();
        long bitis2 = System.nanoTime();//hesaplama bitiyor     
        double sure2 = (bitis2-baslangic2)/1000000.0; 
  
         
        System.out.println("Paralel Hesaplanma Süresi " + String.format("%.2f", sure) + " milisaniye.");  
        System.out.println("Seri Hesaplanma Süresi " + String.format("%.2f", sure2) + " milisaniye. \nSonuc Dosyaya yazıldı."); 
        


    }
   
}
