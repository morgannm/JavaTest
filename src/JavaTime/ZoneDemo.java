package JavaTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ZoneDemo {
    public static void main(String[] args) {
        Map<String, String> maps = ZoneId.SHORT_IDS;
        System.out.println("Liste des fuseaux horaires");
        maps.values().stream().forEach((x) -> {System.out.println(x + " -- " + ZoneId.of(x).getRules());});

        //Et connaître notre fuseau
        System.out.println();
        System.out.println("Fuseau horaire courant : "+ZoneId.systemDefault());
        System.out.println("Règle appliquer aux heures : " + ZoneId.systemDefault().getRules());

        // Heure dans différents fuseaux
        System.out.println();
        System.out.println("Heure à différents fuseaux");
        LocalDateTime ldt = LocalDateTime.parse("2018-01-01T01:33:00");
        List<ZoneId> lzi = Arrays.asList(
                ZoneId.of("Europe/Paris"),
                ZoneId.of("Asia/Tokyo"),
                ZoneId.of("America/Anchorage")
        );

        lzi	.stream()
                .forEach((x) -> {
                    System.out.println(x + " : \t" + ldt.atZone(x).toInstant());
                });
    }
}
