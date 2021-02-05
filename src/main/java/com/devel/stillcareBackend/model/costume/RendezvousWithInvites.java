package com.devel.stillcareBackend.model.costume;

import com.devel.stillcareBackend.model.InviteEntity;
import com.devel.stillcareBackend.model.RendezvousEntity;

import java.util.ArrayList;

public class RendezvousWithInvites {
    private RendezvousEntity rendezvous;
    private ArrayList<InviteEntity> inviterlist;

    public RendezvousEntity getRendezvous() {
        return rendezvous;
    }

    public void setRendezvous(RendezvousEntity rendezvous) {
        this.rendezvous = rendezvous;
    }

    public ArrayList<InviteEntity> getInviterlist() {
        return inviterlist;
    }

    public void setInviterlist(ArrayList<InviteEntity> inviterlist) {
        this.inviterlist = inviterlist;
    }
}
