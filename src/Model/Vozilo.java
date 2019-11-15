package Model;


import java.util.Date;

public class Vozilo {

//    Tip,Marka,GodinaProizvodnje,InicijalniKM
    private int IDVozilo;

    public int getIDVozilo() {
        return IDVozilo;
    }

    public void setIDVozilo(int IDVozilo) {
        this.IDVozilo = IDVozilo;
    }

    private String Tip;
    private String Marka;
    private Date GodinaProizvodnje;
    private int InicijalKM;

    public String getTip() {
        return Tip;
    }

    public void setTip(String tip) {
        Tip = tip;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String marka) {
        Marka = marka;
    }

    public Date getGodinaProizvodnje() {
        return GodinaProizvodnje;
    }

    public void setGodinaProizvodnje(Date godinaProizvodnje) {
        GodinaProizvodnje = godinaProizvodnje;
    }

    public int getInicijalKM() {
        return InicijalKM;
    }

    public void setInicijalKM(int inicijalKM) {
        InicijalKM = inicijalKM;
    }

    public Vozilo() {

    }
}
