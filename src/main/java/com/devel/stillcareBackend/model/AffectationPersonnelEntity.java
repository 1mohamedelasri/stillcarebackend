package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AFFECTATION_PERSONNEL")
@IdClass(AffectationPersonnelEntityPK.class)
public class AffectationPersonnelEntity {
    private long idUnite;
    private long idPersonnel;
    private Date dateAffectation;

    @Id
    @Column(name = "ID_UNITE")
    public long getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(long idUnite) {
        this.idUnite = idUnite;
    }

    @Id
    @Column(name = "ID_PERSONNEL")
    public long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @Basic
    @Column(name = "DATE_AFFECTATION")
    public Date getDateAffectation() {
        return dateAffectation;
    }

    public void setDateAffectation(Date dateAffectation) {
        this.dateAffectation = dateAffectation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AffectationPersonnelEntity that = (AffectationPersonnelEntity) o;

        if (idUnite != that.idUnite) return false;
        if (idPersonnel != that.idPersonnel) return false;
        if (dateAffectation != null ? !dateAffectation.equals(that.dateAffectation) : that.dateAffectation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUnite ^ (idUnite >>> 32));
        result = 31 * result + (int) (idPersonnel ^ (idPersonnel >>> 32));
        result = 31 * result + (dateAffectation != null ? dateAffectation.hashCode() : 0);
        return result;
    }
}
