package javamail.uyeler;

import java.io.*;
import java.util.ArrayList;

public class GenelUye extends Uye{

    private String uyeTipi;

    public GenelUye(String isim, String soyisim, String email) {
        super(isim, soyisim, email);
        this.uyeTipi = "Genel";
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
            if(satir.equals("#Genel Uyeler")){
                icerik += this.getIsim() + "\t" + this.getSoyisim() + "\t" + this.getEmail() + "\n";
            }

            satir = br.readLine();
        }
        fr.close();


        FileWriter fw = new FileWriter(dosya);

        fw.write(icerik);

        fw.close();

        System.out.println(this.getIsim() + " genel üyelere eklendi!");
    }

    public static ArrayList<String> genelUyeleriBul() throws IOException {

        ArrayList<String> genelUyeler = new ArrayList<>();

        File dosya = new File("Kullanicilar.txt");

        FileReader fr = new FileReader(dosya);

        BufferedReader br = new BufferedReader(fr);


        String satir = br.readLine();
        int control = 0;

        while (satir != null) {
            if(!satir.equals("#Genel Uyeler") && control == 0){
                satir = br.readLine();
            }

            else if(satir.equals("#Genel Uyeler")){
                control++;
                satir = br.readLine();
            }
            else{
                genelUyeler.add(satir.split("\t")[2]);
                satir = br.readLine();
            }

        }
        fr.close();

        return genelUyeler;
    }
}
