package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AFFECTATION_PERSONNEL", schema = "ELASRIM", catalog = "")
@IdClass(AffectationPersonnelEntityPK.class)
public class AffectationPersonnelEntity {
    private long idUnite;
    private long idPersonnel;
    private Date datedebut;
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
    @Column(name = "ID_PERSONNEL")
    public long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @Basic
    @Column(name = "DATEDEBUT")
    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
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

        AffectationPersonnelEntity that = (AffectationPersonnelEntity) o;

        if (idUnite != that.idUnite) return false;
        if (idPersonnel != that.idPersonnel) return false;
        if (datedebut != null ? !datedebut.equals(that.datedebut) : that.datedebut != null) return false;
        if (datefin != null ? !datefin.equals(that.datefin) : that.datefin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUnite ^ (idUnite >>> 32));
        result = 31 * result + (int) (idPersonnel ^ (idPersonnel >>> 32));
        result = 31 * result + (datedebut != null ? datedebut.hashCode() : 0);
        result = 31 * result + (datefin != null ? datefin.hashCode() : 0);
        return result;
    }
}
