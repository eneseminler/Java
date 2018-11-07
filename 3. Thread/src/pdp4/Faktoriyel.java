/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdp4;

import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kivircik
 */
public class Faktoriyel implements Runnable {
    private BigInteger sayi= new BigInteger("1");
    private Sayi Sonuc;
    private long u;
    private int ThreadAralik;
    public Faktoriyel(Sayi a, long y,int g){ 
  
    Sonuc = a;
    u=y;
    ThreadAralik = g;
    }
    
      @Override     public void run() {
        
       for ( long z = u; z < Sonuc.SayiNe()+1; z+=ThreadAralik) {
        for(long i=z; i<z+ThreadAralik; i++)
        {
           sayi = sayi.multiply(BigInteger.valueOf(i));  
        }
        }     
         
        try {
            Sonuc.SonucYap(sayi);
        } catch (IOException ex) {
            Logger.getLogger(Faktoriyel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
}
