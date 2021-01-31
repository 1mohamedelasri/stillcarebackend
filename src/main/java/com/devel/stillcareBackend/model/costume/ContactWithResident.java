package com.devel.stillcareBackend.model.costume;


import com.devel.stillcareBackend.model.ContactEntity;

public class ContactWithResident {
    private ContactEntity contact;
    private ResidentIds[] residentIds;

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

    public ResidentIds[] getResidentIds() {
        return residentIds;
    }

    public void setResidentIds(ResidentIds[] residentIds) {
        this.residentIds = residentIds;
    }


}
