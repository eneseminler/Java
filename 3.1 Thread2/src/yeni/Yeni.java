package yeni;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Yeni 
{
    public static void main(String[] args) throws IOException, InterruptedException {

        long hesaplanacakFaktoriyel;
         Scanner al = new Scanner(System.in);
         System.out.print("Faktöriyeli istenen sayı: ");
         hesaplanacakFaktoriyel = al.nextLong();
        
        int threadsayisi = (int) (hesaplanacakFaktoriyel/50);
        
        Sayi sayi = new Sayi(hesaplanacakFaktoriyel);
         long baslangicSeri = System.nanoTime(); //hesaplama başlıyor 
       // System.out.println(SeriFaktoriyel(hesaplanacakFaktoriyel));
       SeriFaktoriyel(hesaplanacakFaktoriyel);
        long bitisSeri = System.nanoTime();//hesaplama bitiyor       
        double sureSeri = (bitisSeri-baslangicSeri)/1000000.0; 
        System.out.println("Seri Hesaplama : "+sureSeri+" milisaniye \n");

        
        ExecutorService havuz = Executors.newFixedThreadPool(threadsayisi);
        long baslangicParalel = System.nanoTime();
            for (int i = 1; i < hesaplanacakFaktoriyel; i+=50) {
               havuz.execute(new FaktoriyelParca(sayi,i+49, i));
               Thread.sleep(15);
        }
         havuz.shutdown();
         
        while(!havuz.isTerminated()){ }
          long bitisParalel = System.nanoTime();
      
        sayi.SonucBitir(sayi);
       
         double gecenSure = (bitisParalel-baslangicParalel)/1000000.0; 

        System.out.println("Paralel hesaplama : "+gecenSure+" milisaniye");
    }

    public static BigInteger SeriFaktoriyel(long sayi){
        BigInteger sonuc = BigInteger.valueOf(1);
        for (int i = 1; i <= sayi ; i++) {
            sonuc = sonuc.multiply(BigInteger.valueOf(i));
        }
        return sonuc;
    }
}


