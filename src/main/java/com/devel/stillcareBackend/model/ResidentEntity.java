package com.devel.stillcareBackend.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "RESIDENT", schema = "ELASRIM", catalog = "")
public class ResidentEntity {
    private long idResident;
    private Time datenaissance;
    private String statut;

    @Id
    @Column(name = "ID_RESIDENT")
    public long getIdResident() {
        return idResident;
    }

    public void setIdResident(long idResident) {
        this.idResident = idResident;
    }

    @Basic
    @Column(name = "DATENAISSANCE")
    public Time getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Time datenaissance) {
        this.datenaissance = datenaissance;
    }

    @Basic
    @Column(name = "STATUT")
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResidentEntity that = (ResidentEntity) o;

        if (idResident != that.idResident) return false;
        if (datenaissance != null ? !datenaissance.equals(that.datenaissance) : that.datenaissance != null)
            return false;
        if (statut != null ? !statut.equals(that.statut) : that.statut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idResident ^ (idResident >>> 32));
        result = 31 * result + (datenaissance != null ? datenaissance.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        return result;
    }
}
