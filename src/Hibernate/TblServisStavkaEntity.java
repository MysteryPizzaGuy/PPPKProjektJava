package Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tblServisStavka", schema = "dbo", catalog = "VehicleControl")
public class TblServisStavkaEntity {
    private int idServisStavka;
    private String naziv;

    @Id
    @Column(name = "IDServisStavka", nullable = false)
    public int getIdServisStavka() {
        return idServisStavka;
    }

    public void setIdServisStavka(int idServisStavka) {
        this.idServisStavka = idServisStavka;
    }

    @Basic
    @Column(name = "Naziv", nullable = true, length = 50)
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblServisStavkaEntity that = (TblServisStavkaEntity) o;
        return idServisStavka == that.idServisStavka &&
                Objects.equals(naziv, that.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServisStavka, naziv);
    }
}
