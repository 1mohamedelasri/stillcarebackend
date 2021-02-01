package com.devel.stillcareBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "INVITERDV", catalog = "")
@IdClass(InviterdvEntityPK.class)
public class InviterdvEntity {
    private long idRdv;
    private long idInvite;

    @Id
    @Column(name = "ID_RDV")
    public long getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(long idRdv) {
        this.idRdv = idRdv;
    }

    @Id
    @Column(name = "ID_INVITE")
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

        InviterdvEntity that = (InviterdvEntity) o;

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
