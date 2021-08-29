package JavaTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PeriodDurationDemo {
    public static void main(String[] args) {
        //Toujours notre 25 Décembre 2018 a 13H37
        LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER, 25, 13, 37, 0);
        LocalDateTime ldt2 = ldt.plus(3, ChronoUnit.YEARS);
        LocalDateTime ldt3 = ldt.minusMinutes(1337);

        Period p = Period.between(ldt.toLocalDate(), ldt2.toLocalDate());
        Duration d = Duration.between(ldt.toLocalTime(), ldt3.toLocalTime());
        System.out.println("Période : " + p);
        System.out.println("Durée : " + d.getSeconds());
        System.out.println("Ecart en jour : " + ChronoUnit.DAYS.between(ldt, ldt2));

        // Différence entre 2 dates LocalDate (autre méthode)
        System.out.println("Différence entre 2 dates LocalDate (autre méthode) --------------");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
        String inputString1 = "01 01 1997";
        String inputString2 = "23 01 1997";

        LocalDate date1 = LocalDate.parse(inputString1, dtf);
        LocalDate date2 = LocalDate.parse(inputString2, dtf);
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println ("Days: " + daysBetween);

        // Différence entre 2 dates Date converties en LocalDate
        System.out.println("Différence entre 2 dates Date converties en LocalDate --------------");
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        try {
            Date date3 = myFormat.parse(inputString1);
            Date date4 = myFormat.parse(inputString2);
            ldt3 = LocalDateTime.ofInstant(date3.toInstant(), ZoneId.systemDefault());
            LocalDateTime ldt4 = LocalDateTime.ofInstant(date4.toInstant(), ZoneId.systemDefault());
            daysBetween = Duration.between(ldt3,ldt4).toDays();
            System.out.println ("Days: " + daysBetween);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
