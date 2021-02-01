package com.devel.stillcareBackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class InviteRdvEntityPK implements Serializable {
    private String mailInvite;
    private long idRdv;

    @Column(name = "MAIL_INVITE")
    @Id
    public String getMailInvite() {
        return mailInvite;
    }

    public void setMailInvite(String mailInvite) {
        this.mailInvite = mailInvite;
    }

    @Column(name = "ID_RDV")
    @Id
    public long getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(long idRdv) {
        this.idRdv = idRdv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InviteRdvEntityPK that = (InviteRdvEntityPK) o;

        if (idRdv != that.idRdv) return false;
        if (mailInvite != null ? !mailInvite.equals(that.mailInvite) : that.mailInvite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mailInvite != null ? mailInvite.hashCode() : 0;
        result = 31 * result + (int) (idRdv ^ (idRdv >>> 32));
        return result;
    }
}
