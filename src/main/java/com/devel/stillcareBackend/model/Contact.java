package com.devel.stillcareBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contact {

  @Id
  private String idContact;
  private String nom;
  private String prenom;
  private String numtel;


  public String getIdContact() {
    return idContact;
  }

  public void setIdContact(String idContact) {
    this.idContact = idContact;
  }


  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }


  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }


  public String getNumtel() {
    return numtel;
  }

  public void setNumtel(String numtel) {
    this.numtel = numtel;
  }

}
