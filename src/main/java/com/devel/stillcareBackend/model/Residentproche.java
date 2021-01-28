package com.devel.stillcareBackend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Residentproche {

  @Id
  @Column(name = "Id_CONTACT")
  private String idContact;
  @Column(name = "Id_RESIDENT")
  private String idResident;
  private String lienfamilial;


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


  public String getLienfamilial() {
    return lienfamilial;
  }

  public void setLienfamilial(String lienfamilial) {
    this.lienfamilial = lienfamilial;
  }

}
