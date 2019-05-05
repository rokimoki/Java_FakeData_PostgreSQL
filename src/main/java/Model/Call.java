package Model;

import Controller.DateController;

import java.util.GregorianCalendar;

public class Call {
    private int id, user;
    private String telephone;
    private GregorianCalendar callDate, createdDate, modifiedDate;

    public Call(int user, String telephone, GregorianCalendar callDate) {
        this.user = user;
        this.telephone = telephone;
        this.callDate = callDate;
        this.createdDate = new GregorianCalendar();
        this.modifiedDate = new GregorianCalendar();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUser() {
        return user;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public GregorianCalendar getCallDate() {
        return callDate;
    }

    public void setCallDate(GregorianCalendar callDate) {
        this.callDate = callDate;
    }

    public GregorianCalendar getCreatedDate() {
        return createdDate;
    }

    public GregorianCalendar getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(GregorianCalendar modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", user=" + user +
                ", telephone='" + telephone + '\'' +
                ", callDate=" + DateController.getStringFormattedDate(callDate) +
                ", createdDate=" + DateController.getStringFormattedDate(createdDate) +
                ", modifiedDate=" + DateController.getStringFormattedDate(modifiedDate) +
                '}';
    }
}
