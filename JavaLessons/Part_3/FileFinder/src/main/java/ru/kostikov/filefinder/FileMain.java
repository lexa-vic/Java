package ru.kostikov.filefinder;

import java.nio.file.*;

import org.apache.commons.cli.*;


/**
 * Created by Алексей on 20.08.2016.
 */
public class FileMain extends SimpleFileVisitor<Path> {

    public static void main(String[] args) {
        Option optDirect   = new Option("d", true, "Directory");
        Option optAnyMatch = new Option("n", true, "Any matcher");
        Option optMask = new Option("m", true, "Mask");
        Option optName = new Option("f", true, "Full name");
        Option optRegExp = new Option("r", true, "RegExp");
        Option optHelp = new Option("h", false, "Help");

        Options options = new Options();
        options.addOption(optDirect);
        options.addOption(optAnyMatch);
        options.addOption(optMask);
        options.addOption(optName);
        options.addOption(optRegExp);
        options.addOption(optHelp);

        CommandLineParser parser = new DefaultParser();

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "help", options );

        try {
            CommandLine cmd = parser.parse( options, args);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (options.hasOption("h")){
            System.out.println("time");
        }

    }
}
