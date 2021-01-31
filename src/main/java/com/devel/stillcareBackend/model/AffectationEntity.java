package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "AFFECTATION", schema = "ELASRIM", catalog = "")
@IdClass(AffectationEntityPK.class)
public class AffectationEntity {
    private long idUnite;
    private long idResident;
    private Time dateaffectation;

    public AffectationEntity(long idUnite, long idResident, Time dateaffectation) {
        this.idUnite = idUnite;
        this.idResident = idResident;
        this.dateaffectation = dateaffectation;
    }

    public AffectationEntity() {

    }

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
    public Time getDateaffectation() {
        return dateaffectation;
    }

    public void setDateaffectation(Time dateaffectation) {
        this.dateaffectation = dateaffectation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AffectationEntity that = (AffectationEntity) o;

        if (idUnite != that.idUnite) return false;
        if (idResident != that.idResident) return false;
        if (dateaffectation != null ? !dateaffectation.equals(that.dateaffectation) : that.dateaffectation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUnite ^ (idUnite >>> 32));
        result = 31 * result + (int) (idResident ^ (idResident >>> 32));
        result = 31 * result + (dateaffectation != null ? dateaffectation.hashCode() : 0);
        return result;
    }
}
