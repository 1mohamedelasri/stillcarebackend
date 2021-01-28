package com.devel.stillcareBackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class InviterdvEntityPK implements Serializable {
    private long idRdv;
    private long idInvite;

    @Column(name = "ID_RDV")
    @Id
    public long getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(long idRdv) {
        this.idRdv = idRdv;
    }

    @Column(name = "ID_INVITE")
    @Id
    public long getIdInvite() {
        return idInvite;
    }

    public void setIdInvite(long idInvite) {
        this.idInvite = idInvite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InviterdvEntityPK that = (InviterdvEntityPK) o;

        if (idRdv != that.idRdv) return false;
        if (idInvite != that.idInvite) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idRdv ^ (idRdv >>> 32));
        result = 31 * result + (int) (idInvite ^ (idInvite >>> 32));
        return result;
    }
}
