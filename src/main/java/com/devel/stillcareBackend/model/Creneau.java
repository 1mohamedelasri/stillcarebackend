package com.devel.stillcareBackend.model;


public class Creneau {

  private String idPersonnel;
  private java.sql.Date datedebut;
  private String idRdv;
  private String etat;


  public String getIdPersonnel() {
    return idPersonnel;
  }

  public void setIdPersonnel(String idPersonnel) {
    this.idPersonnel = idPersonnel;
  }


  public java.sql.Date getDatedebut() {
    return datedebut;
  }

  public void setDatedebut(java.sql.Date datedebut) {
    this.datedebut = datedebut;
  }


  public String getIdRdv() {
    return idRdv;
  }

  public void setIdRdv(String idRdv) {
    this.idRdv = idRdv;
  }


  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }

}
