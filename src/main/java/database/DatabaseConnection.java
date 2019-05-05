package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private String databaseEngine, host, port, database, user, password, connectionString;

    public DatabaseConnection(String databaseEngine, String host, String port, String database, String user, String password) {
        this.databaseEngine = databaseEngine;
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
        this.connectionString = "jdbc:" + this.databaseEngine + "://" + this.host + ":" + this.port + "/" + this.database;
    }

    public Connection getDataBaseConnection() throws SQLException {
        return DriverManager.getConnection(this.connectionString, this.user, this.password);
    }

    public boolean testDataBaseConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            // Where is your PostgreSQL JDBC Driver? Include in your library path!
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(this.connectionString, this.user, this.password);
        } catch (SQLException e) {
            // Connection Failed! Check output console
            e.printStackTrace();
        }
        if (connection == null) {
            return false;
        }
        return true;
    }
}
