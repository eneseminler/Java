/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yeni;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

/**
 *
 * @author Kivircik
 */
public class Sayi {
    private long sayi;
    private BigInteger sonuc = new BigInteger("1");
    
    public Sayi(long a){
    sayi=a;
    }
    public BigInteger SonucNe(){
    return sonuc;
    }
    public void SonucYap(BigInteger a){
    sonuc = a.multiply(sonuc);
    }
    public void SonucBitir(Sayi k) throws IOException{
    sonuc = k.SonucNe();
    File file = new File("sonuc.txt");
      if (!file.exists()) {
            file.createNewFile();
      }
    FileWriter fileWriter = new FileWriter(file, false);
    BufferedWriter bWriter = new BufferedWriter(fileWriter);
    
    String a = "";
    a = sonuc + " ";
    
    bWriter.write(a);
    bWriter.close();     
    }
}
