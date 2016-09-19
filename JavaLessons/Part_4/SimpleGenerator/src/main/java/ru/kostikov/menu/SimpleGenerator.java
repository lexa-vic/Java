package ru.kostikov.menu;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Алексей on 19.09.2016.
 */
public class SimpleGenerator {


    /**
     * It substitutes value in Patter to params in map
     * @param pattern
     * @param params
     * @return
     */
    String generate(Optional<String> pattern, Optional<Map<String, String>>  params){
        String result = null;
        Pattern regExp = Pattern.compile("\\$\\{(\\w+)\\}");
        Matcher matcher = null;

        if (pattern.isPresent() && params.isPresent()){
            int counter;
            StringBuffer sb = new StringBuffer();
            matcher = regExp.matcher(pattern.get());

            while (matcher.find()){
                try {
                    matcher.appendReplacement(sb, params.get().get(matcher.group(1)));

                } catch (NullPointerException e) {
                    sb = null;
                    break;
                }
            }
            if (sb != null){
                matcher.appendTail(sb);
                result = sb.toString();
            }
        }
        return result;
    }

}
