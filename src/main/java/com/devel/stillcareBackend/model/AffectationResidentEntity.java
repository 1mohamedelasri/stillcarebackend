package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AFFECTATION_RESIDENT", schema = "ELASRIM", catalog = "")
@IdClass(AffectationResidentEntityPK.class)
public class AffectationResidentEntity {
    private long idUnite;
    private long idResident;
    private Date dateaffectation;
    private Date datefin;

    @Id
    @Column(name = "ID_UNITE")
    public long getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(long idUnite) {
        this.idUnite = idUnite;
    }

    @Id
    @Column(name = "ID_RESIDENT")
    public long getIdResident() {
        return idResident;
    }

    public void setIdResident(long idResident) {
        this.idResident = idResident;
    }

    @Basic
    @Column(name = "DATEAFFECTATION")
    public Date getDateaffectation() {
        return dateaffectation;
    }

    public void setDateaffectation(Date dateaffectation) {
        this.dateaffectation = dateaffectation;
    }

    @Basic
    @Column(name = "DATEFIN")
    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AffectationResidentEntity that = (AffectationResidentEntity) o;

        if (idUnite != that.idUnite) return false;
        if (idResident != that.idResident) return false;
        if (dateaffectation != null ? !dateaffectation.equals(that.dateaffectation) : that.dateaffectation != null)
            return false;
        if (datefin != null ? !datefin.equals(that.datefin) : that.datefin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUnite ^ (idUnite >>> 32));
        result = 31 * result + (int) (idResident ^ (idResident >>> 32));
        result = 31 * result + (dateaffectation != null ? dateaffectation.hashCode() : 0);
        result = 31 * result + (datefin != null ? datefin.hashCode() : 0);
        return result;
    }
}
