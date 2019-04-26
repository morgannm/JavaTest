package TypesDonnees;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by morgannm on 18/07/2018.
 */
public class DateDemo {
    public static void main(String[] args) {
        System.out.println(new Date());
        long tst = Long.parseLong("1531908728574");
        Date dt = new Timestamp(tst);
        //dt.setTime(tst);
        System.out.println(dt);
    }
}
