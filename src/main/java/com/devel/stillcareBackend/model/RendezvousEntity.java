package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RENDEZVOUS", schema = "ELASRIM", catalog = "")
public class RendezvousEntity {
    private long idRdv;
    private Date dateheuredebut;
    private Date dateheurefin;
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
    @Column(name = "DATEHEUREDEBUT")
    public Date getDateheuredebut() {
        return dateheuredebut;
    }

    public void setDateheuredebut(Date dateheuredebut) {
        this.dateheuredebut = dateheuredebut;
    }

    @Basic
    @Column(name = "DATEHEUREFIN")
    public Date getDateheurefin() {
        return dateheurefin;
    }

    public void setDateheurefin(Date dateheurefin) {
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
        result = 31 * result + (dateheuredebut != null ? dateheuredebut.hashCode() : 0);
        result = 31 * result + (dateheurefin != null ? dateheurefin.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        return result;
    }
}
