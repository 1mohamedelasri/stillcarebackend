package com.devel.stillcareBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESIDENT")
public class Unite {

  @Id
  @Column(name ="ID_RESIDENT")
  private String idUnite;
  @Column(name = "ID_PERSONNEL")
  private String idPersonnel;
  private String nom;
  private String etat;


  public String getIdUnite() {
    return idUnite;
  }

  public void setIdUnite(String idUnite) {
    this.idUnite = idUnite;
  }


  public String getIdEphad() {
    return idPersonnel;
  }

  public void setIdEphad(String idEphad) {
    this.idPersonnel = idEphad;
  }


  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }


  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }

}
