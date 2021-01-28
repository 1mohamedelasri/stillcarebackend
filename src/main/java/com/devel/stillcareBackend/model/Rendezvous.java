package com.devel.stillcareBackend.model;


public class Rendezvous {

  private String idRdv;
  private String idPersonnel;
  private String idContact;
  private String idResident;
  private String creIdPersonnel;
  private java.sql.Date datedebut;
  private String ntablette;
  private java.sql.Date dateheuredebut;
  private java.sql.Date dateheurefin;
  private String statut;
  private String etat;


  public String getIdRdv() {
    return idRdv;
  }

  public void setIdRdv(String idRdv) {
    this.idRdv = idRdv;
  }


  public String getIdPersonnel() {
    return idPersonnel;
  }

  public void setIdPersonnel(String idPersonnel) {
    this.idPersonnel = idPersonnel;
  }


  public String getIdContact() {
    return idContact;
  }

  public void setIdContact(String idContact) {
    this.idContact = idContact;
  }


  public String getIdResident() {
    return idResident;
  }

  public void setIdResident(String idResident) {
    this.idResident = idResident;
  }


  public String getCreIdPersonnel() {
    return creIdPersonnel;
  }

  public void setCreIdPersonnel(String creIdPersonnel) {
    this.creIdPersonnel = creIdPersonnel;
  }


  public java.sql.Date getDatedebut() {
    return datedebut;
  }

  public void setDatedebut(java.sql.Date datedebut) {
    this.datedebut = datedebut;
  }


  public String getNtablette() {
    return ntablette;
  }

  public void setNtablette(String ntablette) {
    this.ntablette = ntablette;
  }


  public java.sql.Date getDateheuredebut() {
    return dateheuredebut;
  }

  public void setDateheuredebut(java.sql.Date dateheuredebut) {
    this.dateheuredebut = dateheuredebut;
  }


  public java.sql.Date getDateheurefin() {
    return dateheurefin;
  }

  public void setDateheurefin(java.sql.Date dateheurefin) {
    this.dateheurefin = dateheurefin;
  }


  public String getStatut() {
    return statut;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }


  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }

}
