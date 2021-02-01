package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RENDEZVOUS")
public class RendezvousEntity {
    private long idRdv;
    private Long idRemplacant;
    private long idContact;
    private long idResident;
    private Date dateCreneau;
    private Date datedebutRdv;
    private Long idTablette;
    private Date datefinRdv;
    private String statut;
    private String etat;
    private Long idPersonnelcreneau;

    @Id
    @Column(name = "ID_RDV")
    public long getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(long idRdv) {
        this.idRdv = idRdv;
    }

    @Basic
    @Column(name = "ID_REMPLACANT")
    public Long getIdRemplacant() {
        return idRemplacant;
    }

    public void setIdRemplacant(Long idRemplacant) {
        this.idRemplacant = idRemplacant;
    }

    @Basic
    @Column(name = "ID_CONTACT")
    public long getIdContact() {
        return idContact;
    }

    public void setIdContact(long idContact) {
        this.idContact = idContact;
    }

    @Basic
    @Column(name = "ID_RESIDENT")
    public long getIdResident() {
        return idResident;
    }

    public void setIdResident(long idResident) {
        this.idResident = idResident;
    }

    @Basic
    @Column(name = "DATE_CRENEAU")
    public Date getDateCreneau() {
        return dateCreneau;
    }

    public void setDateCreneau(Date dateCreneau) {
        this.dateCreneau = dateCreneau;
    }

    @Basic
    @Column(name = "DATEDEBUT_RDV")
    public Date getDatedebutRdv() {
        return datedebutRdv;
    }

    public void setDatedebutRdv(Date datedebutRdv) {
        this.datedebutRdv = datedebutRdv;
    }

    @Basic
    @Column(name = "ID_TABLETTE")
    public Long getIdTablette() {
        return idTablette;
    }

    public void setIdTablette(Long idTablette) {
        this.idTablette = idTablette;
    }

    @Basic
    @Column(name = "DATEFIN_RDV")
    public Date getDatefinRdv() {
        return datefinRdv;
    }

    public void setDatefinRdv(Date datefinRdv) {
        this.datefinRdv = datefinRdv;
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
    @Column(name = "ETAT")
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Basic
    @Column(name = "ID_PERSONNELCRENEAU")
    public Long getIdPersonnelcreneau() {
        return idPersonnelcreneau;
    }

    public void setIdPersonnelcreneau(Long idPersonnelcreneau) {
        this.idPersonnelcreneau = idPersonnelcreneau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RendezvousEntity that = (RendezvousEntity) o;

        if (idRdv != that.idRdv) return false;
        if (idContact != that.idContact) return false;
        if (idResident != that.idResident) return false;
        if (idRemplacant != null ? !idRemplacant.equals(that.idRemplacant) : that.idRemplacant != null) return false;
        if (dateCreneau != null ? !dateCreneau.equals(that.dateCreneau) : that.dateCreneau != null) return false;
        if (datedebutRdv != null ? !datedebutRdv.equals(that.datedebutRdv) : that.datedebutRdv != null) return false;
        if (idTablette != null ? !idTablette.equals(that.idTablette) : that.idTablette != null) return false;
        if (datefinRdv != null ? !datefinRdv.equals(that.datefinRdv) : that.datefinRdv != null) return false;
        if (statut != null ? !statut.equals(that.statut) : that.statut != null) return false;
        if (etat != null ? !etat.equals(that.etat) : that.etat != null) return false;
        if (idPersonnelcreneau != null ? !idPersonnelcreneau.equals(that.idPersonnelcreneau) : that.idPersonnelcreneau != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idRdv ^ (idRdv >>> 32));
        result = 31 * result + (idRemplacant != null ? idRemplacant.hashCode() : 0);
        result = 31 * result + (int) (idContact ^ (idContact >>> 32));
        result = 31 * result + (int) (idResident ^ (idResident >>> 32));
        result = 31 * result + (dateCreneau != null ? dateCreneau.hashCode() : 0);
        result = 31 * result + (datedebutRdv != null ? datedebutRdv.hashCode() : 0);
        result = 31 * result + (idTablette != null ? idTablette.hashCode() : 0);
        result = 31 * result + (datefinRdv != null ? datefinRdv.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        result = 31 * result + (idPersonnelcreneau != null ? idPersonnelcreneau.hashCode() : 0);
        return result;
    }
}
