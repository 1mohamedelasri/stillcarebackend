package com.devel.stillcareBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "INVITE_RDV")
@IdClass(InviteRdvEntityPK.class)
public class InviteRdvEntity {
    private String mailInvite;
    private long idRdv;

    @Id
    @Column(name = "MAIL_INVITE")
    public String getMailInvite() {
        return mailInvite;
    }

    public void setMailInvite(String mailInvite) {
        this.mailInvite = mailInvite;
    }

    @Id
    @Column(name = "ID_RDV")
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

        InviteRdvEntity that = (InviteRdvEntity) o;

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
