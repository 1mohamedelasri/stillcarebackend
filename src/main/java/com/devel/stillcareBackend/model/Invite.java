package com.devel.stillcareBackend.model;


public class Invite {

  private String idInvite;
  private String nom;
  private String prenom;
  private String mail;


  public String getIdInvite() {
    return idInvite;
  }

  public void setIdInvite(String idInvite) {
    this.idInvite = idInvite;
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


  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

}
