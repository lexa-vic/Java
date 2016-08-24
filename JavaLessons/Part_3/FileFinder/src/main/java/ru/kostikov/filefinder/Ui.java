package ru.kostikov.filefinder;

import org.apache.commons.cli.*;

/**
 * Created by Алексей on 24.08.2016.
 */
public class Ui {
    /** Парсер аргументов */
    private CommandLineParser parser;
    /** Опции для парсера аргументов*/
    private Options options;
    /** Поддерживаемые параметры программы*/
    private Option optDirect   = new Option("d", true, "Directory");
    private Option optAnyMatch = new Option("n", true, "Any matcher");
    private Option optMask     = new Option("m", true, "Mask");
    private Option optName     = new Option("f", true, "Full name");
    private Option optRegExp   = new Option("r", true, "RegExp");
//    private Option optHelp     = new Option("h", false, "Help");

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
            if (cmd.hasOption("f")){
                parseValue.matchTemplate = new FullNameMatcher(cmd.getOptionValue("f"));
            }
            if (cmd.hasOption("m")){
                parseValue.matchTemplate = new GlobMacther(cmd.getOptionValue("m"));
            }
        } catch (ParseException e) {
            System.out.println("Введите корретные параметры");
        }

        return parseValue;
    }
}

class ParseValue{
    public String url;
    public Matcher matchTemplate;
}