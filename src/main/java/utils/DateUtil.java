package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String getDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("d-MM-YYYY");
        String data = dataFormat.format(localDate);
        return data;
    }

    public static String getTime() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String time = timeFormatter.format(localTime);
        return time;
    }

}
