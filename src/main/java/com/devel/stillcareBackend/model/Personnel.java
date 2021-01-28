package com.devel.stillcareBackend.model;


public class Personnel {

  private String idPersonnel;
  private String idUnite;
  private String uniIdUnite;
  private String mail;
  private String fonction;
  private String ntel;
  private java.sql.Date datedebut;
  private java.sql.Date datefin;


  public String getIdPersonnel() {
    return idPersonnel;
  }

  public void setIdPersonnel(String idPersonnel) {
    this.idPersonnel = idPersonnel;
  }


  public String getIdUnite() {
    return idUnite;
  }

  public void setIdUnite(String idUnite) {
    this.idUnite = idUnite;
  }


  public String getUniIdUnite() {
    return uniIdUnite;
  }

  public void setUniIdUnite(String uniIdUnite) {
    this.uniIdUnite = uniIdUnite;
  }


  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }


  public String getFonction() {
    return fonction;
  }

  public void setFonction(String fonction) {
    this.fonction = fonction;
  }


  public String getNtel() {
    return ntel;
  }

  public void setNtel(String ntel) {
    this.ntel = ntel;
  }


  public java.sql.Date getDatedebut() {
    return datedebut;
  }

  public void setDatedebut(java.sql.Date datedebut) {
    this.datedebut = datedebut;
  }


  public java.sql.Date getDatefin() {
    return datefin;
  }

  public void setDatefin(java.sql.Date datefin) {
    this.datefin = datefin;
  }

}
