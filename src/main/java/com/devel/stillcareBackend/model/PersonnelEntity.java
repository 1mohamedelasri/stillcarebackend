package com.devel.stillcareBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "PERSONNEL")
public class PersonnelEntity {
    private long idPersonnel;
    private String mail;
    private String fonction;
    private String ntel;
    private long idEhpad;
    private String login;
    private String password;
    private String nom;
    private String prenom;

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
    @Column(name = "ID_EHPAD")
    public long getIdEhpad() {
        return idEhpad;
    }

    public void setIdEhpad(long idEhpad) {
        this.idEhpad = idEhpad;
    }

    @Basic
    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonnelEntity that = (PersonnelEntity) o;

        if (idPersonnel != that.idPersonnel) return false;
        if (idEhpad != that.idEhpad) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (fonction != null ? !fonction.equals(that.fonction) : that.fonction != null) return false;
        if (ntel != null ? !ntel.equals(that.ntel) : that.ntel != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPersonnel ^ (idPersonnel >>> 32));
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (fonction != null ? fonction.hashCode() : 0);
        result = 31 * result + (ntel != null ? ntel.hashCode() : 0);
        result = 31 * result + (int) (idEhpad ^ (idEhpad >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        return result;
    }
}
