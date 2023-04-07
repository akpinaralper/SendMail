package javamail;

import static javamail.uyeler.ElitUye.elitUyeleriBul;
import static javamail.uyeler.GenelUye.genelUyeleriBul;

import java.util.ArrayList;
import java.util.Scanner;

import javamail.uyeler.ElitUye;
import javamail.uyeler.GenelUye;

public class JavaMail {
    public static void main(String[] args) throws Exception {

        System.out.println("1 - Elit Uye Ekleme");
        System.out.println("2 - Genel Uye Ekleme");
        System.out.println("3 - Mail Gonderme");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Secim: ");
        int secim = scanner.nextInt();
        scanner.nextLine();

        if (secim == 1) {

            System.out.println("Isim: ");
            String isim = scanner.nextLine();
            System.out.println("Soyisim: ");
            String soyisim = scanner.nextLine();
            System.out.println("Email: ");
            String email = scanner.nextLine();

            ElitUye elit = new ElitUye(isim, soyisim, email);
            elit.dosyayaYazdir();

        } else if (secim == 2) {
            System.out.println("Isim: ");
            String isim = scanner.nextLine();
            System.out.println("Soyisim: ");
            String soyisim = scanner.nextLine();
            System.out.println("Email: ");
            String email = scanner.nextLine();

            GenelUye genel = new GenelUye(isim, soyisim, email);
            genel.dosyayaYazdir();
        } else if (secim == 3) {

            System.out.println("1- Elit Uyelere Mail");
            System.out.println("2- Genel Uyelere Mail");
            System.out.println("3- Tüm Uyelere Mail");

            System.out.println("Secim:");
            int menuSecim = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Posta içeriğini girin: ");
            String mailText = scanner.nextLine();


            if (menuSecim == 1) {

                ArrayList<String> elitUyeler = elitUyeleriBul();

                for (String kim : elitUyeler) {
                    JavaMailUtil.sendMail(kim, mailText, "Elit Uyeler");
                }

            } else if (menuSecim == 2) {

                ArrayList<String> genelUyeler = genelUyeleriBul();

                for (String kim : genelUyeler) {
                    JavaMailUtil.sendMail(kim, mailText, "Genel Uyeler");
                }
            } else if (menuSecim == 3) {

                ArrayList<String> tumUyeler = elitUyeleriBul();
                for (String genelUye : genelUyeleriBul()) {
                    tumUyeler.add(genelUye);
                }

                for (String kim : tumUyeler) {
                    JavaMailUtil.sendMail(kim, mailText, "Tum Uyeler");
                }

            } else {
                System.out.println("Lutfen menuden dogru secim yapiniz!");
            }

        } else {
            System.out.println("Lutfen menuden dogru secim yapiniz!");
        }

    }

}
