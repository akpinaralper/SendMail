package javamail.uyeler;

import java.io.*;
import java.util.ArrayList;

public class ElitUye extends Uye{

    private String uyeTipi;
    public ElitUye(String isim, String soyisim, String email){
        super(isim,soyisim,email);
        this.uyeTipi = "Elit";
    }

    public String getUyeTipi() {
        return uyeTipi;
    }

    public void setUyeTipi(String uyeTipi) {
        this.uyeTipi = uyeTipi;
    }

    public void dosyayaYazdir() throws IOException {

        File dosya = new File("Kullanicilar.txt");

        FileReader fr = new FileReader(dosya);

        BufferedReader br = new BufferedReader(fr);

        String icerik = "";
        String satir = br.readLine();

        while (satir != null) {

            icerik += satir + "\n";
            if(satir.equals("#Elit Uyeler")){
                icerik += this.getIsim() + "\t" + this.getSoyisim() + "\t" + this.getEmail() + "\n";
            }

            satir = br.readLine();
        }
        fr.close();


        FileWriter fw = new FileWriter(dosya);

        fw.write(icerik);

        fw.close();

        System.out.println(this.getIsim() + " elit üyelere eklendi!");

    }

    public static ArrayList<String> elitUyeleriBul() throws IOException {

        ArrayList<String> elitUyeler = new ArrayList<>();

        File dosya = new File("Kullanicilar.txt");

        FileReader fr = new FileReader(dosya);

        BufferedReader br = new BufferedReader(fr);


        String satir = br.readLine();

        while (satir != null) {
            if(satir.equals("")){
                break;
            }

            else if(satir.equals("#Elit Uyeler")){
                satir = br.readLine();
            }
            else{
                elitUyeler.add(satir.split("\t")[2]);
                satir = br.readLine();
            }

        }
        fr.close();

        return elitUyeler;
    }
}
