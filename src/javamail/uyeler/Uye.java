package javamail.uyeler;

public class Uye {

    private String isim;
    private String soyisim;
    private String email;

    public Uye(String isim, String soyisim, String email) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.email = email;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
