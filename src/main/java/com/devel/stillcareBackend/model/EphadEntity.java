package com.devel.stillcareBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "EPHAD", schema = "ELASRIM", catalog = "")
public class EphadEntity {
    private long idEphad;
    private String nom;

    @Id
    @Column(name = "ID_EPHAD")
    public long getIdEphad() {
        return idEphad;
    }

    public void setIdEphad(long idEphad) {
        this.idEphad = idEphad;
    }

    @Basic
    @Column(name = "NOM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EphadEntity that = (EphadEntity) o;

        if (idEphad != that.idEphad) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idEphad ^ (idEphad >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
    }
}
