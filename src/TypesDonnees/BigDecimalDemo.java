package TypesDonnees;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        double total = 123.456;
        BigDecimal totalBD = new BigDecimal(total);
        totalBD = totalBD.setScale(2,BigDecimal.ROUND_DOWN);
        System.out.println(totalBD); // => 123.45
    }
}
