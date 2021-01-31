package com.devel.stillcareBackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

public class CreneauEntityPK implements Serializable {
    private long idPersonnel;
    private Date datedebut;

    @Column(name = "ID_PERSONNEL")
    @Id
    public long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @Column(name = "DATEDEBUT")
    @Id
    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreneauEntityPK that = (CreneauEntityPK) o;

        if (idPersonnel != that.idPersonnel) return false;
        if (datedebut != null ? !datedebut.equals(that.datedebut) : that.datedebut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPersonnel ^ (idPersonnel >>> 32));
        result = 31 * result + (datedebut != null ? datedebut.hashCode() : 0);
        return result;
    }
}
