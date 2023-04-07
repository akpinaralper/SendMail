package javamail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailUtil {

    public static void sendMail(String recepient, String mailText, String mailSubject) throws Exception {
   /*
    -Proje gmail host sunucusu kullanılarak hazırlanmıştır.

    - Mail gönderebilmek için mail adresi ve "Google My Account" sitesinden elde edilecek "App Password" ile çalışmaktadır.
    - Bu şifreyi elde etmek için öncelikle "2 Adımlı Doğrulama" açılmalıdır ve "Uygulama Şifreleri" alanından 16 haneli şifre kullanılmalıdır.

       */
        Properties properties = System.getProperties();
     /*

      - "JavaMailUtil" sınıfının içerisindeki "myAccountEmail" ve "password" String değişkenlerine test hesabı yazılarak proje çalıştırılabilir.
     */
        String myAccountEmail = "nesneyeyonelik.22120205067@gmail.com";
        String password = "xeuqjqcrxnadsdpd";
        String host = "smtp.gmail.com";

        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.user",myAccountEmail);
        properties.put("mail.smtp.password",password);
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.auth","true");

        Session session = Session.getDefaultInstance(properties);

        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Java Mail Uygulaması - " + mailSubject);
            message.setText(mailText);

            Transport t = session.getTransport("smtp");
            t.connect(host,myAccountEmail,password);
            t.sendMessage(message,message.getAllRecipients());
            t.close();

        }
        catch (Exception e){
            System.out.println("Hata!");
            throw new Exception();
        }
        System.out.println("Başarılı -> " + recepient + " adresine gönderildi.");
    }
}
