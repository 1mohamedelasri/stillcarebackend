package com.devel.stillcareBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "TABLETTE", schema = "ELASRIM", catalog = "")
public class TabletteEntity {
    private long ntablette;
    private String etat;

    public TabletteEntity(long ntablette, String etat) {
        this.ntablette = ntablette;
        this.etat = etat;
    }

    public TabletteEntity() {
    }

    @Id
    @Column(name = "NTABLETTE")
    public long getNtablette() {
        return ntablette;
    }

    public void setNtablette(long ntablette) {
        this.ntablette = ntablette;
    }

    @Basic
    @Column(name = "ETAT")
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabletteEntity that = (TabletteEntity) o;

        if (ntablette != that.ntablette) return false;
        if (etat != null ? !etat.equals(that.etat) : that.etat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (ntablette ^ (ntablette >>> 32));
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        return result;
    }
}
