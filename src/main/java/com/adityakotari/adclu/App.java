package com.adityakotari.adclu;

import java.io.IOException;

import org.fusesource.jansi.AnsiConsole;

public class App {
     
    public static final String ANSI_RED = "\u001B[31m";     
    public static final String ANSI_RESET = "\u001B[0m"; 

    public static void main( String[] args )throws IOException {
        
        Parsed parsed = new Parsed( args );
        run(parsed);
    }

    
    public static void run(Parsed parsed) throws IOException{

        if(parsed.greetee!=null)
            System.out.println("Hello "+parsed.greetee+"!");
        else if(!parsed.diffFilePaths.isEmpty())
            Diff.run(parsed);
        else
            System.out.println("Wrong input parameters, please try again.");
    }
}
