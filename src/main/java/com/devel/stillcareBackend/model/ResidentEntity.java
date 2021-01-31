package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "RESIDENT", schema = "ELASRIM")
public class ResidentEntity {
    private long idResident;
    private long idPersonnel;
    private Date datenaissance;
    private String statut;
    private String nom;
    private String prenom;
    private long idEhpad;

    @Id
    @Column(name = "ID_RESIDENT")
    public long getIdResident() {
        return idResident;
    }

    public void setIdResident(long idResident) {
        this.idResident = idResident;
    }

    @Basic
    @Column(name = "ID_PERSONNEL")
    public long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @Basic
    @Column(name = "DATENAISSANCE")
    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    @Basic
    @Column(name = "STATUT")
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
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
    @Column(name = "PRENOM")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "ID_EHPAD")
    public long getIdEhpad() {
        return idEhpad;
    }

    public void setIdEhpad(long idEhpad) {
        this.idEhpad = idEhpad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResidentEntity that = (ResidentEntity) o;

        if (idResident != that.idResident) return false;
        if (idPersonnel != that.idPersonnel) return false;
        if (idEhpad != that.idEhpad) return false;
        if (datenaissance != null ? !datenaissance.equals(that.datenaissance) : that.datenaissance != null)
            return false;
        if (statut != null ? !statut.equals(that.statut) : that.statut != null) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idResident ^ (idResident >>> 32));
        result = 31 * result + (int) (idPersonnel ^ (idPersonnel >>> 32));
        result = 31 * result + (datenaissance != null ? datenaissance.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (int) (idEhpad ^ (idEhpad >>> 32));
        return result;
    }
}
