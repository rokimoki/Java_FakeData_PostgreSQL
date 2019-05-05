package Controller;

import Model.Incident;
import View.IncidentView;
import View.ErrorView;
import database.IncidentDB;

import java.sql.SQLException;

public class IncidentController {

    public static void createIncident(Incident incident) {
        try {
            long id = IncidentDB.insertIncident(incident);
            incident.setId((int) id);
            IncidentView.printIncident(incident);
        } catch (SQLException e) {
            ErrorView.printError(e.getMessage());
        }
    }
}
