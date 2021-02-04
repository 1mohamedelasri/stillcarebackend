package com.devel.stillcareBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "EHPAD")
public class EhpadEntity {
    private long idEhpad;
    private String nom;
    private String numtel;
    private String adresse;
    private Long capacite;

    @Id
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
    @Column(name = "NUMTEL")
    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    @Basic
    @Column(name = "ADRESSE")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "CAPACITE")
    public Long getCapacite() {
        return capacite;
    }

    public void setCapacite(Long capacite) {
        this.capacite = capacite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EhpadEntity that = (EhpadEntity) o;

        if (idEhpad != that.idEhpad) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (numtel != null ? !numtel.equals(that.numtel) : that.numtel != null) return false;
        if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
        if (capacite != null ? !capacite.equals(that.capacite) : that.capacite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idEhpad ^ (idEhpad >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (numtel != null ? numtel.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (capacite != null ? capacite.hashCode() : 0);
        return result;
    }
}
