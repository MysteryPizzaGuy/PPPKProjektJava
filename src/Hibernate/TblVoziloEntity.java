package Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tblVozilo", schema = "dbo", catalog = "VehicleControl")
public class TblVoziloEntity {
    private int idVozilo;
    private String tip;
    private String marka;
    private Timestamp godinaProizvodnje;
    private Integer inicijalniKm;
    private Set<TblPutniNalogEntity> putniNalogEntitySet;

    @Id
    @Column(name = "IDVozilo", nullable = false)
    public int getIdVozilo() {
        return idVozilo;
    }

    public void setIdVozilo(int idVozilo) {
        this.idVozilo = idVozilo;
    }

    @Basic
    @Column(name = "Tip", nullable = true, length = 50)
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Basic
    @Column(name = "Marka", nullable = true, length = 50)
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Basic
    @Column(name = "GodinaProizvodnje", nullable = true)
    public Timestamp getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(Timestamp godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    @Basic
    @Column(name = "InicijalniKM", nullable = true)
    public Integer getInicijalniKm() {
        return inicijalniKm;
    }

    public void setInicijalniKm(Integer inicijalniKm) {
        this.inicijalniKm = inicijalniKm;
    }

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)

    public Set<TblPutniNalogEntity> getPutniNalogEntitySet() {
        return putniNalogEntitySet;
    }

    public void setPutniNalogEntitySet(Set<TblPutniNalogEntity> putniNalogEntitySet) {
        this.putniNalogEntitySet = putniNalogEntitySet;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblVoziloEntity that = (TblVoziloEntity) o;
        return idVozilo == that.idVozilo &&
                Objects.equals(tip, that.tip) &&
                Objects.equals(marka, that.marka) &&
                Objects.equals(godinaProizvodnje, that.godinaProizvodnje) &&
                Objects.equals(inicijalniKm, that.inicijalniKm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVozilo, tip, marka, godinaProizvodnje, inicijalniKm);
    }
}
