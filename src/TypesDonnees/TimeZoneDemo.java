package TypesDonnees;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar.getTimeZone() : " + calendar.getTimeZone());
        Date dt = Date.from(Instant.now());
        System.out.println("Date.from(Instant.now()) : " + dt);
        dt = calendar.getTime();
        System.out.println("dt : " + dt);

        // Liste des time zones
        String[] tz = TimeZone.getAvailableIDs();

        // Imposer la time zone par défaut
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        // NB : si on modifie la time zone par Calendar.getInstance(TimeZone.getTimeZone("Europe/London"))
        //      la time zone est bien modifiée, mais calendar1.getTime() donne l'heure de la time zone par défaut
        Calendar calendar1 = Calendar.getInstance(); // NB :
        System.out.println("calendar1.getTimeZone() : " + calendar1.getTimeZone());
        dt = calendar1.getTime();
        System.out.println("dt : " + dt); // heure de Londres
    }
}
