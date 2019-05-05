package database;

import Controller.DateController;
import Model.Incident;

import java.sql.*;

public class IncidentDB {
    public static long insertIncident(Incident incident) throws SQLException {
        String query = "INSERT INTO Incidente (llamada, tipoIncidente, descripcion, fechaCreacion, fechaEdicion) VALUES (?, ?, ?, ?, ?)";

        long id = 0;

        Connection databaseConnection = PostgresDatabaseConnection.getPotgresDatabaseConnection();

        PreparedStatement pstmt = databaseConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        pstmt.setInt(1, incident.getCall());
        pstmt.setString(2, incident.getIncidentType());
        pstmt.setString(3, incident.getDescription());
        pstmt.setDate(4, DateController.getSqlDate(incident.getCreatedDate())); // Missing hour and minutes in SQL Date
        pstmt.setDate(5, DateController.getSqlDate(incident.getModifiedDate()));

        int affectedRows = pstmt.executeUpdate();

        if (affectedRows > 0) {
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
        }

        databaseConnection.close();

        return id;
    }
}
