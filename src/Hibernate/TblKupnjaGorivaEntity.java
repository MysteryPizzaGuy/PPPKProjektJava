package Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tblKupnjaGoriva", schema = "dbo", catalog = "VehicleControl")
public class TblKupnjaGorivaEntity {
    private int idKupnjaGoriva;
    private String lokacija;
    private Double gorivoPoLitri;
    private Double cijenaPoLitri;

    @Id
    @Column(name = "IDKupnjaGoriva", nullable = false)
    public int getIdKupnjaGoriva() {
        return idKupnjaGoriva;
    }

    public void setIdKupnjaGoriva(int idKupnjaGoriva) {
        this.idKupnjaGoriva = idKupnjaGoriva;
    }

    @Basic
    @Column(name = "Lokacija", nullable = true, length = 100)
    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    @Basic
    @Column(name = "GorivoPoLitri", nullable = true, precision = 0)
    public Double getGorivoPoLitri() {
        return gorivoPoLitri;
    }

    public void setGorivoPoLitri(Double gorivoPoLitri) {
        this.gorivoPoLitri = gorivoPoLitri;
    }

    @Basic
    @Column(name = "CijenaPoLitri", nullable = true, precision = 0)
    public Double getCijenaPoLitri() {
        return cijenaPoLitri;
    }

    public void setCijenaPoLitri(Double cijenaPoLitri) {
        this.cijenaPoLitri = cijenaPoLitri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblKupnjaGorivaEntity that = (TblKupnjaGorivaEntity) o;
        return idKupnjaGoriva == that.idKupnjaGoriva &&
                Objects.equals(lokacija, that.lokacija) &&
                Objects.equals(gorivoPoLitri, that.gorivoPoLitri) &&
                Objects.equals(cijenaPoLitri, that.cijenaPoLitri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKupnjaGoriva, lokacija, gorivoPoLitri, cijenaPoLitri);
    }
}
