package com.devel.stillcareBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TABLETTE")
public class Tablette {

  @Id
  private String ntablette;
  private String etat;


  public String getNtablette() {
    return ntablette;
  }

  public void setNtablette(String ntablette) {
    this.ntablette = ntablette;
  }


  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }

}
