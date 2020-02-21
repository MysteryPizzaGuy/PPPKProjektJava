package Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tblVozac", schema = "dbo", catalog = "VehicleControl")
public class TblVozacEntity {
    private int idVozac;
    private String ime;
    private String prezime;
    private String brojMobitela;
    private String serijskiBrojVozacke;
    private Set<TblPutniNalogEntity> putniNalogEntityset;

    @Id
    @Column(name = "IDVozac", nullable = false)
    public int getIdVozac() {
        return idVozac;
    }

    public void setIdVozac(int idVozac) {
        this.idVozac = idVozac;
    }

    @Basic
    @Column(name = "Ime", nullable = true, length = 50)
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Basic
    @Column(name = "Prezime", nullable = true, length = 50)
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Basic
    @Column(name = "BrojMobitela", nullable = true, length = 50)
    public String getBrojMobitela() {
        return brojMobitela;
    }

    public void setBrojMobitela(String brojMobitela) {
        this.brojMobitela = brojMobitela;
    }

    @Basic
    @Column(name = "SerijskiBrojVozacke", nullable = true, length = 8)
    public String getSerijskiBrojVozacke() {
        return serijskiBrojVozacke;
    }

    public void setSerijskiBrojVozacke(String serijskiBrojVozacke) {
        this.serijskiBrojVozacke = serijskiBrojVozacke;
    }




    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)

    public Set<TblPutniNalogEntity> getPutniNalogEntityset() {
        return putniNalogEntityset;
    }

    public void setPutniNalogEntityset(Set<TblPutniNalogEntity> putniNalogEntityset) {
        this.putniNalogEntityset = putniNalogEntityset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblVozacEntity that = (TblVozacEntity) o;
        return idVozac == that.idVozac &&
                Objects.equals(ime, that.ime) &&
                Objects.equals(prezime, that.prezime) &&
                Objects.equals(brojMobitela, that.brojMobitela) &&
                Objects.equals(serijskiBrojVozacke, that.serijskiBrojVozacke);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVozac, ime, prezime, brojMobitela, serijskiBrojVozacke);
    }
}
