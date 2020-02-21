package Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tblServis", schema = "dbo", catalog = "VehicleControl")
public class TblServisEntity {
    private int idServis;
    private Date datum;
    private String naziv;
    private String opis;
    private Double cijena;

    @Id
    @Column(name = "IDServis", nullable = false)
    public int getIdServis() {
        return idServis;
    }

    public void setIdServis(int idServis) {
        this.idServis = idServis;
    }

    @Basic
    @Column(name = "Datum", nullable = true)
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Basic
    @Column(name = "Naziv", nullable = true, length = 50)
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Basic
    @Column(name = "Opis", nullable = true, length = 250)
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Basic
    @Column(name = "Cijena", nullable = true, precision = 0)
    public Double getCijena() {
        return cijena;
    }

    public void setCijena(Double cijena) {
        this.cijena = cijena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblServisEntity that = (TblServisEntity) o;
        return idServis == that.idServis &&
                Objects.equals(datum, that.datum) &&
                Objects.equals(naziv, that.naziv) &&
                Objects.equals(opis, that.opis) &&
                Objects.equals(cijena, that.cijena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServis, datum, naziv, opis, cijena);
    }
}
