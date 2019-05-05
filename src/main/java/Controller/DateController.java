package Controller;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.GregorianCalendar;

public class DateController {

    private static final String dateTimeFormatString = "yyyy-MM-dd HH:mm:ss.SSSX";
    private static final String dateFormatString = "yyyy-MM-dd";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat(dateTimeFormatString);

    public static String getTodayDateStamp() {
        GregorianCalendar today = new GregorianCalendar();
        return getStringFormattedDate(today);
    }

    public static String getTodayDateTimeStamp() {
        GregorianCalendar today = new GregorianCalendar();
        return getStringFormattedDateTime(today);
    }

    public static String getStringFormattedDateTime(GregorianCalendar date) {
        dateTimeFormat.setCalendar(date);
        return dateTimeFormat.format(date.getTime());
    }

    public static String getStringFormattedDate(GregorianCalendar date) {
        dateTimeFormat.setCalendar(date);
        return dateTimeFormat.format(date.getTime());
    }

    public static Date getSqlDate(GregorianCalendar date) {
        return new Date(date.getTimeInMillis());
    }
}
