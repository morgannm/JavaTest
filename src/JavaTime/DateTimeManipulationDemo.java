package JavaTime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeManipulationDemo {
    public static void main(String[] args) {
        //Le 25 Décembre 2018 a 13H37
        LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER, 25, 13, 37, 0);
        System.out.println("Date de référence : " + ldt);
        //Utilisation de l'objet ChronoUnit pour changer l'objet
        System.out.println("+1 semaine : " + ldt.plus(1, ChronoUnit.WEEKS));
        System.out.println("+2 mois : " + ldt.plus(2, ChronoUnit.MONTHS));
        System.out.println("+3 ans : " + ldt.plus(3, ChronoUnit.YEARS));
        System.out.println("+4 heures : " + ldt.plus(4, ChronoUnit.HOURS));
        System.out.println("-5 secondes : " + ldt.minus(5, ChronoUnit.SECONDS));
        System.out.println("-38 minutes : " + ldt.minusMinutes(38));
        System.out.println("-1 jour : " + ldt.minus(1, ChronoUnit.DAYS));

        // Modification d'une date java.util.date en utilisant java.util.time
        System.out.println("====================================");
        Date dateAujourdhui = Date.from(Instant.now());
        System.out.println("Aujourd'hui : " + dateAujourdhui);
        LocalDateTime hier = LocalDateTime.ofInstant(dateAujourdhui.toInstant(), ZoneId.systemDefault()).minusDays(1);
        Date dateHier = Date.from(hier.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("Hier : " + dateHier);

        // idem avec LocalDate au lieu de LocalDateTime
        LocalDate ldtSup = LocalDate.from(LocalDateTime.ofInstant(dateAujourdhui.toInstant(), ZoneId.systemDefault())).minus(3, ChronoUnit.MONTHS);
        System.out.println(ldtSup);
    }
}
