package com.devel.stillcareBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT", schema = "ELASRIM", catalog = "")
public class ContactEntity {
    private long idContact;
    private String nom;
    private String prenom;
    private String numtel;

    @Id
    @Column(name = "ID_CONTACT")
    public long getIdContact() {
        return idContact;
    }

    public void setIdContact(long idContact) {
        this.idContact = idContact;
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
    @Column(name = "NUMTEL")
    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEntity that = (ContactEntity) o;

        if (idContact != that.idContact) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (numtel != null ? !numtel.equals(that.numtel) : that.numtel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idContact ^ (idContact >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (numtel != null ? numtel.hashCode() : 0);
        return result;
    }
}
