package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RESIDENT", schema = "BADZII", catalog = "")
public class ResidentEntity {
    private long idResident;
    private String nom;
    private String prenom;
    private Date datenaissance;
    private String statut;
    private Long idUnite;
    private Date dateaffectation;
    private long idPersonnel;
    private Date dateaffectperson;

    @Id
    @Column(name = "ID_RESIDENT")
    public long getIdResident() {
        return idResident;
    }

    public void setIdResident(long idResident) {
        this.idResident = idResident;
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
    @Column(name = "ID_UNITE")
    public Long getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(Long idUnite) {
        this.idUnite = idUnite;
    }

    @Basic
    @Column(name = "DATEAFFECTATION")
    public Date getDateaffectation() {
        return dateaffectation;
    }

    public void setDateaffectation(Date dateaffectation) {
        this.dateaffectation = dateaffectation;
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
    @Column(name = "DATEAFFECTPERSON")
    public Date getDateaffectperson() {
        return dateaffectperson;
    }

    public void setDateaffectperson(Date dateaffectperson) {
        this.dateaffectperson = dateaffectperson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResidentEntity that = (ResidentEntity) o;

        if (idResident != that.idResident) return false;
        if (idPersonnel != that.idPersonnel) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (datenaissance != null ? !datenaissance.equals(that.datenaissance) : that.datenaissance != null)
            return false;
        if (statut != null ? !statut.equals(that.statut) : that.statut != null) return false;
        if (idUnite != null ? !idUnite.equals(that.idUnite) : that.idUnite != null) return false;
        if (dateaffectation != null ? !dateaffectation.equals(that.dateaffectation) : that.dateaffectation != null)
            return false;
        if (dateaffectperson != null ? !dateaffectperson.equals(that.dateaffectperson) : that.dateaffectperson != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idResident ^ (idResident >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (datenaissance != null ? datenaissance.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        result = 31 * result + (idUnite != null ? idUnite.hashCode() : 0);
        result = 31 * result + (dateaffectation != null ? dateaffectation.hashCode() : 0);
        result = 31 * result + (int) (idPersonnel ^ (idPersonnel >>> 32));
        result = 31 * result + (dateaffectperson != null ? dateaffectperson.hashCode() : 0);
        return result;
    }
}
