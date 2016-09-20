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
    String generate(Optional<String> pattern, Optional<Map<String, String>>  params) throws GeneratorExeption{
        String result = null;
        Pattern regExp = Pattern.compile("\\$\\{(\\w+)\\}");
        Matcher matcher = null;

        if (pattern.isPresent() && params.isPresent()){
            int counter = 0;
            StringBuffer sb = new StringBuffer();
            matcher = regExp.matcher(pattern.get());

            while (matcher.find()){
                counter++;
                if (params.get().containsKey(matcher.group(1))){
                    matcher.appendReplacement(sb, params.get().get(matcher.group(1)));
                }else {
                    throw new GeneratorExeption("A required parameter was not found");
                }
            }
            if (counter != params.get().size()){
                throw new GeneratorExeption("Have extra params");
            }else {
                matcher.appendTail(sb);
                result = sb.toString();
            }
        }else {
            throw new GeneratorExeption("Params or pattern was not found");
        }
        return result;
    }
}
