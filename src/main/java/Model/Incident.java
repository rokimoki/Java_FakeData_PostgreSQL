package Model;

import Controller.DateController;

import java.util.GregorianCalendar;

public class Incident {
    private int id, call;
    private String incidentType, description;
    private GregorianCalendar createdDate, modifiedDate;

    public Incident(int call, String incidentType, String description) {
        this.call = call;
        this.incidentType = incidentType;
        this.description = description;
        this.createdDate = new GregorianCalendar();;
        this.modifiedDate = new GregorianCalendar();;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCall() {
        return call;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "Incident{" +
                "id=" + id +
                ", call=" + call +
                ", incidentType='" + incidentType + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + DateController.getStringFormattedDate(createdDate) +
                ", modifiedDate=" + DateController.getStringFormattedDate(modifiedDate) +
                '}';
    }
}
