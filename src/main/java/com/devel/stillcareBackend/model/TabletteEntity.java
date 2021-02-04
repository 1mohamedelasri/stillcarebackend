package com.devel.stillcareBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "TABLETTE")
public class TabletteEntity {
    private long ntablette;
    private Long idEhpad;
    private String etat;

    @Id
    @Column(name = "NTABLETTE")
    public long getNtablette() {
        return ntablette;
    }

    public void setNtablette(long ntablette) {
        this.ntablette = ntablette;
    }

    @Basic
    @Column(name = "ID_EHPAD")
    public Long getIdEhpad() {
        return idEhpad;
    }

    public void setIdEhpad(Long idEhpad) {
        this.idEhpad = idEhpad;
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
        if (idEhpad != null ? !idEhpad.equals(that.idEhpad) : that.idEhpad != null) return false;
        if (etat != null ? !etat.equals(that.etat) : that.etat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (ntablette ^ (ntablette >>> 32));
        result = 31 * result + (idEhpad != null ? idEhpad.hashCode() : 0);
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        return result;
    }
}
