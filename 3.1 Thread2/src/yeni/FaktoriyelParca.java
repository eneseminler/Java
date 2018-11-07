package yeni;

import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FaktoriyelParca implements Runnable{

    private final long buyukSayi;
    private final long kucukSayi;
    private final Sayi sayi;
    public FaktoriyelParca(Sayi a,long buyukSayi, long kucukSayi) {
        this.buyukSayi = buyukSayi;
        this.kucukSayi = kucukSayi;
        sayi=a;
    }

    @Override
    public void run() {
        BigInteger snc = BigInteger.valueOf(1);
        for (long i = kucukSayi; i<buyukSayi; i++) {
            snc = snc.multiply(BigInteger.valueOf(i));
           
        }
            sayi.SonucYap(snc);
    }
}
