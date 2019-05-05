import Controller.*;
import Model.Call;
import Model.Incident;
import Model.User;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] argv) {
        // 1.- Create Users
        for (int i = 0; i < 30; i++) { // Creating users
            String email = RandomStringController.getRandomString(10) + "@gmail.com";
            String name = RandomStringController.getRandomString(8);
            String surname1 = RandomStringController.getRandomString(10);
            String surname2 = RandomStringController.getRandomString(10);
            String telephone = RandomStringController.getRandomNumericString(9);
            String address = RandomStringController.getRandomString(20);
            GregorianCalendar bornDate = new GregorianCalendar(1989, 9, 13);
            User user = new User(email, "fakePassword", name, surname1, surname2, telephone, address, bornDate);
            UserController.createUser(user);
        }

        GregorianCalendar aDate = new GregorianCalendar(2017, 0, 1, 0, 0, 0);
        for (int year = 2016; year <= 2018; year++) {
            for (int month = 0; month <= 11; month++) {
                int maxDay = new GregorianCalendar(year, month, 1).getActualMaximum(Calendar.DAY_OF_MONTH);
                for (int day = 1; day <= maxDay; day++) {
                    int hour = (int) Math.floor(Math.random() * 24);
                    int minute = (int) Math.floor(Math.random() * 60);
                    aDate.set(year, month, day, hour, minute, 0);

                    // 2.- Create calls (400 per day)
                    for (int i = 0; i < 400; i++) {
                        int user = (int) Math.floor(Math.random() * 30 + 1);
                        String telephone = RandomStringController.getRandomNumericString(8);
                        GregorianCalendar callDate = (GregorianCalendar) aDate.clone();
                        Call call = new Call(user, telephone, callDate);
                        CallController.createCall(call);
                    }

                    // 3.- Create incidents (300 per day)
                    for (int i = 0; i < 300; i++) {
                        int minCallId = 400 * (day - 1) + 1, maxCallId = 400 * day;
                        int call = (int) Math.floor(Math.random() * (maxCallId - minCallId + 1) + minCallId);
                        System.out.println("Call: " + call);
                        String incidentType = RandomStringController.getRandomString(20);
                        String description = RandomStringController.getRandomString(250);
                        Incident incident = new Incident(call, incidentType, description);
                        IncidentController.createIncident(incident);
                    }
                }
            }
        }
    }
}
