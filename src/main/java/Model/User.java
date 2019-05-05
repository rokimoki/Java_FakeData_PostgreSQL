package Model;

import Controller.DateController;

import java.util.GregorianCalendar;

public class User {
    private int id;
    private String email, password, name, surname1, surname2, telephone, address;
    private GregorianCalendar bornDate, createdDate, modifiedDate;

    public User(String email, String password, String name, String surname1, String surname2, String telephone, String address, GregorianCalendar bornDate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.telephone = telephone;
        this.address = address;
        this.bornDate = bornDate;
        this.createdDate = new GregorianCalendar();
        this.modifiedDate = new GregorianCalendar();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GregorianCalendar getBornDate() {
        return bornDate;
    }

    public void setBornDate(GregorianCalendar bornDate) {
        this.bornDate = bornDate;
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='****" + '\'' +
                ", surname1='" + surname1 + '\'' +
                ", surname2='" + surname2 + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", bornDate=" + DateController.getStringFormattedDate(bornDate) +
                ", createdDate=" + DateController.getStringFormattedDate(createdDate) +
                ", modifiedDate=" + DateController.getStringFormattedDate(modifiedDate) +
                '}';
    }
}
