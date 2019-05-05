package database;
import Controller.DateController;
import Model.User;

import java.sql.*;

public class UserDB {
    public static long insertUser(User user) throws SQLException {
        String query = "INSERT INTO Usuario (nombre, email, pass, apellido1, apellido2, telefono, direccion, fechaNacimiento, fechaCreacion, fechaEdicion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        long id = 0;

        Connection databaseConnection = PostgresDatabaseConnection.getPotgresDatabaseConnection();

        PreparedStatement pstmt = databaseConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getPassword());
        pstmt.setString(4, user.getSurname1());
        pstmt.setString(5, user.getSurname2());
        pstmt.setString(6, user.getTelephone());
        pstmt.setString(7, user.getAddress());
        pstmt.setDate(8, DateController.getSqlDate(user.getBornDate()));
        pstmt.setDate(9, DateController.getSqlDate(user.getCreatedDate())); // Missing hour and minutes in SQL Date
        pstmt.setDate(10, DateController.getSqlDate(user.getModifiedDate()));

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
