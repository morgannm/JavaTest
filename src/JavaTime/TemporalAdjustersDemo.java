package JavaTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersDemo {
    public static void main(String[] args) {
        // Date de référence 25 décembre 2018
        LocalDate ldt = LocalDate.of(2018, Month.DECEMBER, 25);
        System.out.println("Date de référence : " + ldt.getDayOfWeek() + " " + ldt);

        //Le prochain samedi
        LocalDate prochainSamedi = ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("Samedi suivant : " + prochainSamedi.getDayOfWeek() + " " + prochainSamedi);

        //Le troisième mardi du mois suivant
        //On ajoute un mois à notre date
        ldt = ldt.plus(1, ChronoUnit.MONTHS);
        //On en créer une nouvelle au premier jour du mois
        LocalDate ldt2 = LocalDate.of(ldt.getYear(), ldt.getMonth(), 1);
        //On avance de trois mardi
        LocalDate troisiemeMardi = String.valueOf(ldt2.getDayOfWeek()).equals("TUESDAY") ?
                ldt2
                        .with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
                        .with(TemporalAdjusters.next(DayOfWeek.TUESDAY)) : ldt2.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
                .with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
                .with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("3ème mardi du mois suivant : " + troisiemeMardi.getDayOfWeek() + " " + troisiemeMardi);

    }
}
