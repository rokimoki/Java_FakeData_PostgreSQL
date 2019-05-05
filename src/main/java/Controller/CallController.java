package Controller;

import Model.Call;
import View.CallView;
import View.ErrorView;
import View.UserView;
import database.CallDB;

import java.sql.SQLException;

public class CallController {

    public static void createCall(Call call) {
        try {
            long id = CallDB.insertCall(call);
            call.setId((int) id);
            CallView.printCall(call);
        } catch (SQLException e) {
            ErrorView.printError(e.getMessage());
        }
    }
}
