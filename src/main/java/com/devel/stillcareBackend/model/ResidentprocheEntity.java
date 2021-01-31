package com.devel.stillcareBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "RESIDENTPROCHE", schema = "ELASRIM", catalog = "")
@IdClass(ResidentprocheEntityPK.class)
public class ResidentprocheEntity {
    private long idContact;
    private long idResident;
    private String lienfamilial;

    @Id
    @Column(name = "ID_CONTACT")
    public long getIdContact() {
        return idContact;
    }

    public void setIdContact(long idContact) {
        this.idContact = idContact;
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
    @Column(name = "LIENFAMILIAL")
    public String getLienfamilial() {
        return lienfamilial;
    }

    public void setLienfamilial(String lienfamilial) {
        this.lienfamilial = lienfamilial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResidentprocheEntity that = (ResidentprocheEntity) o;

        if (idContact != that.idContact) return false;
        if (idResident != that.idResident) return false;
        if (lienfamilial != null ? !lienfamilial.equals(that.lienfamilial) : that.lienfamilial != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = (int) (idContact ^ (idContact >>> 32));
        result = 31 * result + (int) (idResident ^ (idResident >>> 32));
        result = 31 * result + (lienfamilial != null ? lienfamilial.hashCode() : 0);
        return result;
    }
}
