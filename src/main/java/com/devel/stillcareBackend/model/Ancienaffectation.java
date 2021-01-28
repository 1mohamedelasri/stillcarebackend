package com.devel.stillcareBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ancienaffectation {

  @Id
  private String idUnite;
  @Id
  private String idResident;


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

}
