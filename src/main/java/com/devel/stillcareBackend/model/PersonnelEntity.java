package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "PERSONNEL", schema = "ELASRIM", catalog = "")
public class PersonnelEntity {
    private long idPersonnel;
    private String mail;
    private String fonction;
    private String ntel;
    private Time datedebut;
    private Time datefin;

    @Id
    @Column(name = "ID_PERSONNEL")
    public long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @Basic
    @Column(name = "MAIL")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "FONCTION")
    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    @Basic
    @Column(name = "NTEL")
    public String getNtel() {
        return ntel;
    }

    public void setNtel(String ntel) {
        this.ntel = ntel;
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
    @Column(name = "DATEFIN")
    public Time getDatefin() {
        return datefin;
    }

    public void setDatefin(Time datefin) {
        this.datefin = datefin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonnelEntity that = (PersonnelEntity) o;

        if (idPersonnel != that.idPersonnel) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (fonction != null ? !fonction.equals(that.fonction) : that.fonction != null) return false;
        if (ntel != null ? !ntel.equals(that.ntel) : that.ntel != null) return false;
        if (datedebut != null ? !datedebut.equals(that.datedebut) : that.datedebut != null) return false;
        if (datefin != null ? !datefin.equals(that.datefin) : that.datefin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPersonnel ^ (idPersonnel >>> 32));
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (fonction != null ? fonction.hashCode() : 0);
        result = 31 * result + (ntel != null ? ntel.hashCode() : 0);
        result = 31 * result + (datedebut != null ? datedebut.hashCode() : 0);
        result = 31 * result + (datefin != null ? datefin.hashCode() : 0);
        return result;
    }
}
