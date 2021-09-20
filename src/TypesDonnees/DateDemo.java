package TypesDonnees;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * Created by morgannm on 18/07/2018.
 */
public class DateDemo {
    public static void main(String[] args) {
        // test Git 1
        System.out.println(new Date());
        long tst = Long.parseLong("1531908728574");
        Date dt = new Timestamp(tst);
        //dt.setTime(tst);
        System.out.println(dt);

        // parse String to date
        String dateStr = "2019-10-02";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dt = formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateStr + " -> " + dt);

        dateStr = "02/10/2019";
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dt = formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateStr + " -> " + dt);

        // Date -> String
        Date maintenant = Date.from(Instant.now());
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Conversion et Formatage Date en String : " + df.format(maintenant));

        // Différence entre 2 dates : voir JavaTime/PeriodDurationDemo
    }
}
