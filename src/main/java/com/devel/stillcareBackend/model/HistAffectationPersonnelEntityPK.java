package com.devel.stillcareBackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class HistAffectationPersonnelEntityPK implements Serializable {
    private long idUnite;
    private long idPersonnel;

    @Column(name = "ID_UNITE")
    @Id
    public long getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(long idUnite) {
        this.idUnite = idUnite;
    }

    @Column(name = "ID_PERSONNEL")
    @Id
    public long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistAffectationPersonnelEntityPK that = (HistAffectationPersonnelEntityPK) o;

        if (idUnite != that.idUnite) return false;
        if (idPersonnel != that.idPersonnel) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUnite ^ (idUnite >>> 32));
        result = 31 * result + (int) (idPersonnel ^ (idPersonnel >>> 32));
        return result;
    }
}
