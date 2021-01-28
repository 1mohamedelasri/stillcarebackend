package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "ANCIENAFFECTATION", schema = "ELASRIM", catalog = "")
@IdClass(AncienaffectationEntityPK.class)
public class AncienaffectationEntity {
    private long idUnite;
    private long idResident;
    private Time datedebut;
    private Time datefin;

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
    @Column(name = "DATEDEBUT")
    public Time getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Time datedebut) {
        this.datedebut = datedebut;
    }

    @Basic
    @Column(name = "DATEFIN")
    public Time getDatefin() {
        return datefin;
    }

    public void setDatefin(Time datefin) {
        this.datefin = datefin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AncienaffectationEntity that = (AncienaffectationEntity) o;

        if (idUnite != that.idUnite) return false;
        if (idResident != that.idResident) return false;
        if (datedebut != null ? !datedebut.equals(that.datedebut) : that.datedebut != null) return false;
        if (datefin != null ? !datefin.equals(that.datefin) : that.datefin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUnite ^ (idUnite >>> 32));
        result = 31 * result + (int) (idResident ^ (idResident >>> 32));
        result = 31 * result + (datedebut != null ? datedebut.hashCode() : 0);
        result = 31 * result + (datefin != null ? datefin.hashCode() : 0);
        return result;
    }
}
