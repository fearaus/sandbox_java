package DateTime;

import java.time.LocalDate;

public class DateTimeFormatter {

    public static void main(String[] args) {

        //parse date from string to another format
        String date ="2020-11-12";
        String newDate = LocalDate.parse(date).format(java.time.format.DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(newDate);
    }
}
