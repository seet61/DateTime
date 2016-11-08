import java.time.*;
import java.time.format.TextStyle;
import java.util.*;

/**
 * Created by dmitry.arefyev on 08.11.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("День недели:");
        DayOfWeek dow = DayOfWeek.TUESDAY;
        Locale locale = Locale.getDefault();
        System.out.println(dow.getDisplayName(TextStyle.FULL, locale));
        System.out.println(dow.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));

        System.out.println("Месяц:");
        Month month = Month.NOVEMBER;
        System.out.println(month.getDisplayName(TextStyle.FULL, locale));
        System.out.println(month.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(month.getDisplayName(TextStyle.SHORT, locale));

        System.out.println("Високосный год:");
        for (int i=2000; i<2021; i++) {
            System.out.println(i + ": " + Year.of(i).isLeap());
        }

/*
        System.out.println("LocalTime:");
        LocalTime thisSec;
        for(;;) {
            thisSec = LocalTime.now();
            System.out.format("%s:%s:%s%n", thisSec.getHour(), thisSec.getMinute(), thisSec.getSecond());
            Thread.sleep(1000);
        }
*/

        System.out.println("Часовые пояса:");
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        LocalDateTime dt = LocalDateTime.now();

        //Сортируем
        List<String> zoneList = new ArrayList<String>(allZones);
        Collections.sort(zoneList);

        for (String zon:zoneList) {
            //System.out.println(zone);
            ZoneId zone = ZoneId.of(zon);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset offset = zdt.getOffset();
            int secondofHour = offset.getTotalSeconds() % (60 * 60);
            String out = String.format("%35s %10s%n", zone, offset);

            System.out.printf(out);
        }
    }
}
