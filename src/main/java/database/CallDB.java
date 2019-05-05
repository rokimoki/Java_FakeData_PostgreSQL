package database;

import Controller.DateController;
import Model.Call;

import java.sql.*;

public class CallDB {
    public static long insertCall(Call call) throws SQLException {
        String query = "INSERT INTO Llamada (usuario, telefono, fechaLlamada, fechaCreacion, fechaEdicion) VALUES (?, ?, ?, ?, ?)";

        long id = 0;

        Connection databaseConnection = PostgresDatabaseConnection.getPotgresDatabaseConnection();

        PreparedStatement pstmt = databaseConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        pstmt.setInt(1, call.getUser());
        pstmt.setString(2, call.getTelephone());
        pstmt.setDate(3, DateController.getSqlDate(call.getCallDate())); // Missing hour and minutes in SQL Date
        pstmt.setDate(4, DateController.getSqlDate(call.getCreatedDate()));
        pstmt.setDate(5, DateController.getSqlDate(call.getModifiedDate()));

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
