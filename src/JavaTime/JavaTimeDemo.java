package JavaTime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class JavaTimeDemo {
    public static void main(String[] args) {
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Date et heure courante : " + currentTime);

        // Horodatage
        System.out.println(currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss")));

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("Date courante : " + date1);

        Month mois = currentTime.getMonth();
        int jour = currentTime.getDayOfMonth();
        int heure = currentTime.getHour();

        System.out.println("Mois : " + mois +", jour : " + jour +", heure : " + heure);

        //Avoir le 25 décembre 2023
        LocalDateTime date2 = currentTime.withDayOfMonth(25).withYear(2023).withMonth(12);
        System.out.println("Date modifiée : " + date2);

        //une autre façon
        LocalDate date3 = LocalDate.of(2023, Month.DECEMBER, 25);
        System.out.println("Autre façon de faire : " + date3);

        //On peut même parser une date depuis un String
        LocalTime parsed = LocalTime.parse("20:15:30");
        System.out.println("Heure parsée : " + parsed);

        System.out.println("=============================");
        LocalDate aujourdhui = LocalDate.now();
        System.out.println("Aujourd'hui : " + aujourdhui);
        LocalDate hier = aujourdhui.minusDays(1);
        System.out.println("Hier : " + hier);
        Period diff = Period.between(hier,aujourdhui);
        System.out.println("Différence : " + diff.getDays());
    }
}
