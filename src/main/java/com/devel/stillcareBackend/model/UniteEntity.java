package com.devel.stillcareBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "UNITE", catalog = "")
public class UniteEntity {
    private long idUnite;
    private long idEhpad;
    private String nom;
    private String etat;

    @Id
    @Column(name = "ID_UNITE")
    public long getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(long idUnite) {
        this.idUnite = idUnite;
    }

    @Basic
    @Column(name = "ID_EHPAD")
    public long getIdEhpad() {
        return idEhpad;
    }

    public void setIdEhpad(long idEhpad) {
        this.idEhpad = idEhpad;
    }

    @Basic
    @Column(name = "NOM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

        UniteEntity that = (UniteEntity) o;

        if (idUnite != that.idUnite) return false;
        if (idEhpad != that.idEhpad) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (etat != null ? !etat.equals(that.etat) : that.etat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUnite ^ (idUnite >>> 32));
        result = 31 * result + (int) (idEhpad ^ (idEhpad >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        return result;
    }
}
