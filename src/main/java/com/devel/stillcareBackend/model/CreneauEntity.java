package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CRENEAU", schema = "ELASRIM", catalog = "")
@IdClass(CreneauEntityPK.class)
public class CreneauEntity {
    private long idPersonnel;
    private Date datedebut;
    private String etat;

    @Id
    @Column(name = "ID_PERSONNEL")
    public long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @Id
    @Column(name = "DATEDEBUT")
    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    @Basic
    @Column(name = "ETAT")
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreneauEntity that = (CreneauEntity) o;

        if (idPersonnel != that.idPersonnel) return false;
        if (datedebut != null ? !datedebut.equals(that.datedebut) : that.datedebut != null) return false;
        if (etat != null ? !etat.equals(that.etat) : that.etat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPersonnel ^ (idPersonnel >>> 32));
        result = 31 * result + (datedebut != null ? datedebut.hashCode() : 0);
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        return result;
    }
}
