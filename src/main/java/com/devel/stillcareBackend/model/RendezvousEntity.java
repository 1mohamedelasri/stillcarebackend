package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "RENDEZVOUS", schema = "ELASRIM", catalog = "")
public class RendezvousEntity {
    private long idRdv;
    private Long idPersonnel;
    private long idContact;
    private long idResident;
    private long creIdPersonnel;
    private Time datedebut;
    private Long ntablette;
    private Time dateheuredebut;
    private Time dateheurefin;
    private String statut;
    private String etat;

    @Id
    @Column(name = "ID_RDV")
    public long getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(long idRdv) {
        this.idRdv = idRdv;
    }

    @Basic
    @Column(name = "ID_PERSONNEL")
    public Long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(Long idPersonnel) {
        this.idPersonnel = idPersonnel;
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
    @Column(name = "CRE_ID_PERSONNEL")
    public long getCreIdPersonnel() {
        return creIdPersonnel;
    }

    public void setCreIdPersonnel(long creIdPersonnel) {
        this.creIdPersonnel = creIdPersonnel;
    }

    @Basic
    @Column(name = "DATEDEBUT")
    public Time getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Time datedebut) {
        this.datedebut = datedebut;
    }

    @Basic
    @Column(name = "NTABLETTE")
    public Long getNtablette() {
        return ntablette;
    }

    public void setNtablette(Long ntablette) {
        this.ntablette = ntablette;
    }

    @Basic
    @Column(name = "DATEHEUREDEBUT")
    public Time getDateheuredebut() {
        return dateheuredebut;
    }

    public void setDateheuredebut(Time dateheuredebut) {
        this.dateheuredebut = dateheuredebut;
    }

    @Basic
    @Column(name = "DATEHEUREFIN")
    public Time getDateheurefin() {
        return dateheurefin;
    }

    public void setDateheurefin(Time dateheurefin) {
        this.dateheurefin = dateheurefin;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RendezvousEntity that = (RendezvousEntity) o;

        if (idRdv != that.idRdv) return false;
        if (idContact != that.idContact) return false;
        if (idResident != that.idResident) return false;
        if (creIdPersonnel != that.creIdPersonnel) return false;
        if (idPersonnel != null ? !idPersonnel.equals(that.idPersonnel) : that.idPersonnel != null) return false;
        if (datedebut != null ? !datedebut.equals(that.datedebut) : that.datedebut != null) return false;
        if (ntablette != null ? !ntablette.equals(that.ntablette) : that.ntablette != null) return false;
        if (dateheuredebut != null ? !dateheuredebut.equals(that.dateheuredebut) : that.dateheuredebut != null)
            return false;
        if (dateheurefin != null ? !dateheurefin.equals(that.dateheurefin) : that.dateheurefin != null) return false;
        if (statut != null ? !statut.equals(that.statut) : that.statut != null) return false;
        if (etat != null ? !etat.equals(that.etat) : that.etat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idRdv ^ (idRdv >>> 32));
        result = 31 * result + (idPersonnel != null ? idPersonnel.hashCode() : 0);
        result = 31 * result + (int) (idContact ^ (idContact >>> 32));
        result = 31 * result + (int) (idResident ^ (idResident >>> 32));
        result = 31 * result + (int) (creIdPersonnel ^ (creIdPersonnel >>> 32));
        result = 31 * result + (datedebut != null ? datedebut.hashCode() : 0);
        result = 31 * result + (ntablette != null ? ntablette.hashCode() : 0);
        result = 31 * result + (dateheuredebut != null ? dateheuredebut.hashCode() : 0);
        result = 31 * result + (dateheurefin != null ? dateheurefin.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        return result;
    }
}
