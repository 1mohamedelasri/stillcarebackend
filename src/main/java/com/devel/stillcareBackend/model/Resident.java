package com.devel.stillcareBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESIDENT")
public class Resident {

  @Id
  @Column(name = "ID_RESIDENT")
  private Integer idResident;

  @Column(name = "ID_PERSONNEL")
  private Integer idPersonnel;
  private java.sql.Date datenaissance;
  private String statut;


  public Integer getIdResident() {
    return idResident;
  }

  public void setIdResident(Integer idResident) {
    this.idResident = idResident;
  }


  public Integer getIdPersonnel() {
    return idPersonnel;
  }

  public void setIdPersonnel(Integer idPersonnel) {
    this.idPersonnel = idPersonnel;
  }


  public java.sql.Date getDatenaissance() {
    return datenaissance;
  }

  public void setDatenaissance(java.sql.Date datenaissance) {
    this.datenaissance = datenaissance;
  }


  public String getStatut() {
    return statut;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }

}
