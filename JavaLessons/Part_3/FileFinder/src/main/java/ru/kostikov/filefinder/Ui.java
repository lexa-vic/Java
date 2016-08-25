package ru.kostikov.filefinder;

import org.apache.commons.cli.*;

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

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("help", this.options);
    }

    /**
     * @param args
     * @return
     */
    public ParseValue argsParse(String[] args){
        ParseValue parseValue = new ParseValue();

        this.initOptions();
        try {
            CommandLine cmd = new DefaultParser().parse(this.options, args);

            if (cmd.hasOption("d")){
                parseValue.url = cmd.getOptionValue("d");
            }

            if (cmd.hasOption("n")) {
                // Ищем по имени
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
        } catch (ParseException e) {
            System.out.println("Введите корретные параметры");
        }
        return parseValue;
    }
}

class ParseValue{
    public String url;
    public FindMatcher matchTemplate;
    public String fileOutName;

}