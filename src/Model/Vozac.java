package Model;

public class Vozac {
    public int getIDVozac() {
        return IDVozac;
    }

    public void setIDVozac(int IDVozac) {
        this.IDVozac = IDVozac;
    }

    //    IME,Prezime,BrojMobitela,SerijskiBrojVozacke
    private int IDVozac;
    private String Ime;
    private String Prezime;
    private String BrojMobitela;
    private String SerijskiBrojVozacke;

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    public String getBrojMobitela() {
        return BrojMobitela;
    }

    public void setBrojMobitela(String brojMobitela) {
        BrojMobitela = brojMobitela;
    }

    public String getSerijskiBrojVozacke() {
        return SerijskiBrojVozacke;
    }

    public void setSerijskiBrojVozacke(String serijskiBrojVozacke) {
        SerijskiBrojVozacke = serijskiBrojVozacke;
    }

    @Override
    public String toString() {
        return "Vozac{" +
                "Ime='" + Ime + '\'' +
                ", Prezime='" + Prezime + '\'' +
                ", BrojMobitela='" + BrojMobitela + '\'' +
                ", SerijskiBrojVozacke='" + SerijskiBrojVozacke + '\'' +
                '}';
    }

    public Vozac() {
    }
}
