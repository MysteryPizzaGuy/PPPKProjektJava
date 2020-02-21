package Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tblPutniNalog", schema = "dbo", catalog = "VehicleControl")
public class TblPutniNalogEntity {
    private int idPutniNalog;
    private String startGrad;
    private String stopGrad;
    private Date startDate;
    private Date stopDate;
    private TblVozacEntity vozac;
    private TblVoziloEntity vozilo;

    @Id
    @Column(name = "IDPutniNalog", nullable = false)
    public int getIdPutniNalog() {
        return idPutniNalog;
    }

    public void setIdPutniNalog(int idPutniNalog) {
        this.idPutniNalog = idPutniNalog;
    }

    @Basic
    @Column(name = "StartGrad", nullable = true, length = 50)
    public String getStartGrad() {
        return startGrad;
    }

    public void setStartGrad(String startGrad) {
        this.startGrad = startGrad;
    }

    @Basic
    @Column(name = "StopGrad", nullable = true, length = 50)
    public String getStopGrad() {
        return stopGrad;
    }

    public void setStopGrad(String stopGrad) {
        this.stopGrad = stopGrad;
    }

    @Basic
    @Column(name = "StartDate", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }



    @ManyToOne
    @JoinColumn(name="VoziloID")
    public TblVoziloEntity getVozilo() {
        return vozilo;
    }

    public void setVozilo(TblVoziloEntity vozilo) {
        this.vozilo = vozilo;
    }

    @ManyToOne
    @JoinColumn(name="VozacID")
    public TblVozacEntity getVozac() {
        return vozac;
    }

    public void setVozac(TblVozacEntity vozac) {
        this.vozac = vozac;
    }



//    @ManyToOne
//    @JoinColumn(name = "SpecializationID")
//    public SpecializationEntity getSpecialization() {
//        return specialization;
//    }
//
//    public void setSpecialization(SpecializationEntity specialization) {
//        this.specialization = specialization;
//    }
//
//    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL,mappedBy ="doctor")
//
//    public Set<AppointmentEntity> getAppointments() {
//        return appointments;
//    }
//
//    public void setAppointments(Set<AppointmentEntity> appointments) {
//        this.appointments = appointments;
//    }
//
//    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL,mappedBy ="doctor")
//

    @Basic
    @Column(name = "StopDate", nullable = true)
    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblPutniNalogEntity that = (TblPutniNalogEntity) o;
        return idPutniNalog == that.idPutniNalog &&
                Objects.equals(startGrad, that.startGrad) &&
                Objects.equals(stopGrad, that.stopGrad) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(stopDate, that.stopDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPutniNalog, startGrad, stopGrad, startDate, stopDate);
    }
}
