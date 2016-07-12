package strings;

/**
 * Created by Алексей on 12.07.2016.
 */
public class StringFindInit {
    public static void main(String[] args) {

        String origin  = "ab bc cd de ef";
        String sub     = "de";
        String is      = "is";
        String isnot   = "is't";
        boolean result = false;

        StringFind stringSub = new StringFind();

        result = stringSub.contains(origin, sub);

        System.out.printf("\"%s\" %s substring of \"%s\"\n",sub, (result ? is: isnot), origin);

        origin  = "ab bc cd de ef";
        sub     = "xc";

        result = stringSub.contains(origin, sub);

        System.out.printf("\"%s\" %s substring of \"%s\"\n",sub, (result ? is: isnot), origin);

    }
}
