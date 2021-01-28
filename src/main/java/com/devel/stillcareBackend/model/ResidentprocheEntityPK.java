package com.devel.stillcareBackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ResidentprocheEntityPK implements Serializable {
    private long idContact;
    private long idResident;

    @Column(name = "ID_CONTACT")
    @Id
    public long getIdContact() {
        return idContact;
    }

    public void setIdContact(long idContact) {
        this.idContact = idContact;
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

        ResidentprocheEntityPK that = (ResidentprocheEntityPK) o;

        if (idContact != that.idContact) return false;
        if (idResident != that.idResident) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idContact ^ (idContact >>> 32));
        result = 31 * result + (int) (idResident ^ (idResident >>> 32));
        return result;
    }
}
