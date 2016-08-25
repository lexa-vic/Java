package ru.kostikov.filefinder;

import org.apache.commons.cli.*;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Алексей on 24.08.2016.
 */
public class Ui {
    /** Парсер аргументов */
    private CommandLineParser parser;
    /** Опции для парсера аргументов*/
    private Options options;
    /** Поддерживаемые параметры программы*/
    private Option optDirect   = new Option("d", true, "Директория поиска");
    private Option optAnyMatch = new Option("n", true, "Имя файла, Регулярное выражение, маска, ");
    private Option optMask     = new Option("m", false, "Искать по маске (Glob выражение)");
    private Option optName     = new Option("f", false, "Искать по полному имени файла");
    private Option optRegExp   = new Option("r", false, "Искать по регулярному выражению");
    private Option optFileOut  = new Option("o", true,  "Имя файла с результатом");

    /**
     *  Инициализация парсера аргументов
     *  Добавляем поддержку параметров
     */
    private void initOptions() {
        this.options = new Options();
        this.options.addOption(optDirect);
        this.options.addOption(optAnyMatch);
        this.options.addOption(optMask);
        this.options.addOption(optName);
        this.options.addOption(optRegExp);
        this.options.addOption(optFileOut);


    }


    /**
     * Парсинг аргументов командной строки
     * @param args  массив аргументов
     * @return Optional<ParseValue> необходимые параметры для поиска
     */
    public Optional<ParseValue> argsParse(String[] args){
        ParseValue parseValue = new ParseValue();
        Optional<ParseValue> result = Optional.empty();

        this.initOptions();
        try {
            CommandLine cmd = new DefaultParser().parse(this.options, args);

            if (cmd.getOptions().length == 0){
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("help", this.options);
                System.out.println("Пример: java -jar find.jar -d c:/ -n *.txt -m -o log.txt");

            }else if (cmd.getOptions().length == 4){
                if (cmd.hasOption("d")){
                    parseValue.url = cmd.getOptionValue("d");
                }

                if (cmd.hasOption("n")) {
                    if (cmd.hasOption("f")) {
                        parseValue.matchTemplate = new FullNameMatcher(cmd.getOptionValue("n"));
                    } else if (cmd.hasOption("m")) {  // Ищем по маске
                        parseValue.matchTemplate = new GlobMacther(cmd.getOptionValue("n"));
                    } else if (cmd.hasOption("r")) {  // Ищем по регулярному выражению
                        try {
                            Pattern pattern = Pattern.compile(cmd.getOptionValue("n"));
                            parseValue.matchTemplate = new RegExpMatcher(pattern);
                        } catch (PatternSyntaxException pe) {
                            System.out.println("Не верное лябда выражение");
                        }
                    }
                }

                if (cmd.hasOption("o")){
                    parseValue.fileOutName = cmd.getOptionValue("o");
                }
            }else{
                System.out.println("Недостаточно параметров");
            }


        } catch (ParseException e) {
            System.out.println("Введите корретные параметры");
        }

        if(parseValue.url           != null &&
           parseValue.matchTemplate != null &&
           parseValue.fileOutName   != null){
            result = Optional.of(parseValue);
        }
        return result;
    }
}

/**
 *  Класс возвращаемых параметров после парсинга аргументов командоной строки
 */
class ParseValue{
    public String url;
    public FindMatcher matchTemplate;
    public String fileOutName;

    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        // obj ссылается на null
        if(obj == null)
            return false;
        // Удостоверимся, что ссылки имеют тот же самый тип
        if(!(getClass() == obj.getClass()))
            return false;
        else
        {
            ParseValue tmp = (ParseValue)obj;
            if((tmp.matchTemplate.equals(this.matchTemplate)) &&
               (tmp.url == this.url) && (tmp.fileOutName == this.fileOutName))
                return true;
            else
                return false;
        }
    }
}