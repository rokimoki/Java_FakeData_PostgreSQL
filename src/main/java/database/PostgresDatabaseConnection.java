package database;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresDatabaseConnection {

    public static Connection getPotgresDatabaseConnection() throws SQLException {
        DatabaseConnection db = new DatabaseConnection("postgresql", "--[HOST]--", "5432", "--[DATABASE]--", "--[USER]--", "--[PASSWORD]--");
        return db.getDataBaseConnection();
    }

}
