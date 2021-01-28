package com.devel.stillcareBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Affectation {
  @Id
  private String idUnite;
  @Id
  private String idResident;
  private java.sql.Date date;


  public String getIdUnite() {
    return idUnite;
  }

  public void setIdUnite(String idUnite) {
    this.idUnite = idUnite;
  }


  public String getIdResident() {
    return idResident;
  }

  public void setIdResident(String idResident) {
    this.idResident = idResident;
  }


  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }

}
