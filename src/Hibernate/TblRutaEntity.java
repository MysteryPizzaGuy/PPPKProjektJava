package Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tblRuta", schema = "dbo", catalog = "VehicleControl")
public class TblRutaEntity {
    private int idRuta;
    private Timestamp vrijeme;
    private Integer aCoordX;
    private Integer aCoordY;
    private Integer bCoordX;
    private Integer bCoordY;
    private Double prijedeniKm;
    private Double prosjecniKmh;
    private Double potrosenoGorivoLitre;
    private TblPutniNalogEntity tblPutniNalogByPutniNalogId;

    @Id
    @Column(name = "IDRuta", nullable = false)
    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    @Basic
    @Column(name = "Vrijeme", nullable = true)
    public Timestamp getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Timestamp vrijeme) {
        this.vrijeme = vrijeme;
    }

    @Basic
    @Column(name = "ACoordX", nullable = true)
    public Integer getaCoordX() {
        return aCoordX;
    }

    public void setaCoordX(Integer aCoordX) {
        this.aCoordX = aCoordX;
    }

    @Basic
    @Column(name = "ACoordY", nullable = true)
    public Integer getaCoordY() {
        return aCoordY;
    }

    public void setaCoordY(Integer aCoordY) {
        this.aCoordY = aCoordY;
    }

    @Basic
    @Column(name = "BCoordX", nullable = true)
    public Integer getbCoordX() {
        return bCoordX;
    }

    public void setbCoordX(Integer bCoordX) {
        this.bCoordX = bCoordX;
    }

    @Basic
    @Column(name = "BCoordY", nullable = true)
    public Integer getbCoordY() {
        return bCoordY;
    }

    public void setbCoordY(Integer bCoordY) {
        this.bCoordY = bCoordY;
    }

    @Basic
    @Column(name = "PrijedeniKM", nullable = true, precision = 0)
    public Double getPrijedeniKm() {
        return prijedeniKm;
    }

    public void setPrijedeniKm(Double prijedeniKm) {
        this.prijedeniKm = prijedeniKm;
    }

    @Basic
    @Column(name = "ProsjecniKMH", nullable = true, precision = 0)
    public Double getProsjecniKmh() {
        return prosjecniKmh;
    }

    public void setProsjecniKmh(Double prosjecniKmh) {
        this.prosjecniKmh = prosjecniKmh;
    }

    @Basic
    @Column(name = "PotrosenoGorivoLitre", nullable = true, precision = 0)
    public Double getPotrosenoGorivoLitre() {
        return potrosenoGorivoLitre;
    }

    public void setPotrosenoGorivoLitre(Double potrosenoGorivoLitre) {
        this.potrosenoGorivoLitre = potrosenoGorivoLitre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblRutaEntity that = (TblRutaEntity) o;
        return idRuta == that.idRuta &&
                Objects.equals(vrijeme, that.vrijeme) &&
                Objects.equals(aCoordX, that.aCoordX) &&
                Objects.equals(aCoordY, that.aCoordY) &&
                Objects.equals(bCoordX, that.bCoordX) &&
                Objects.equals(bCoordY, that.bCoordY) &&
                Objects.equals(prijedeniKm, that.prijedeniKm) &&
                Objects.equals(prosjecniKmh, that.prosjecniKmh) &&
                Objects.equals(potrosenoGorivoLitre, that.potrosenoGorivoLitre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRuta, vrijeme, aCoordX, aCoordY, bCoordX, bCoordY, prijedeniKm, prosjecniKmh, potrosenoGorivoLitre);
    }

    @ManyToOne
    @JoinColumn(name = "PutniNalogID", referencedColumnName = "IDPutniNalog")
    public TblPutniNalogEntity getTblPutniNalogByPutniNalogId() {
        return tblPutniNalogByPutniNalogId;
    }

    public void setTblPutniNalogByPutniNalogId(TblPutniNalogEntity tblPutniNalogByPutniNalogId) {
        this.tblPutniNalogByPutniNalogId = tblPutniNalogByPutniNalogId;
    }
}
