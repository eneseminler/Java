/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdp4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

/**
 *
 * @author Kivircik
 */
public class Sayi {
    private long deger;
    private BigInteger faktoriyel;

    public Sayi(long a){
        deger = a;
        faktoriyel = new BigInteger("1");
    }
    
    public long SayiNe(){
    
        return deger;
    }
   
    public BigInteger SonucNe(){
    return faktoriyel;
    } 
    public void SonucYap(BigInteger b) throws IOException{
        faktoriyel = b;
     File file = new File("sonuc.txt");
        String a = "";
        
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
     
         a = faktoriyel + " ";
         bWriter.write(a);
         bWriter.close();   
    
    }
   
}
