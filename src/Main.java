import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Created by dmitry.arefyev on 08.11.2016.
 */
public class Main {
    public static void main(String[] args) {
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
    }
}
