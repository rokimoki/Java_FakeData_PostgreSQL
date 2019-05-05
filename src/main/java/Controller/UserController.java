package Controller;

import Model.User;
import View.ErrorView;
import View.UserView;
import database.UserDB;

import java.sql.SQLException;

public class UserController {

    public static void createUser(User user) {
        try {
            long id = UserDB.insertUser(user);
            user.setId((int) id);
            UserView.printUser(user);
        } catch (SQLException e) {
            ErrorView.printError(e.getMessage());
        }
    }

}
