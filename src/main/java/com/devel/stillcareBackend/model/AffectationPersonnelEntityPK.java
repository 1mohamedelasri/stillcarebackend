package com.devel.stillcareBackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AffectationPersonnelEntityPK implements Serializable {
    private long idUnite;
    private long idResident;

    @Column(name = "ID_UNITE")
    @Id
    public long getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(long idUnite) {
        this.idUnite = idUnite;
    }

    @Column(name = "ID_RESIDENT")
    @Id
    public long getIdResident() {
        return idResident;
    }

    public void setIdResident(long idResident) {
        this.idResident = idResident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AffectationPersonnelEntityPK that = (AffectationPersonnelEntityPK) o;

        if (idUnite != that.idUnite) return false;
        if (idResident != that.idResident) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUnite ^ (idUnite >>> 32));
        result = 31 * result + (int) (idResident ^ (idResident >>> 32));
        return result;
    }
}
