package com.adityakotari.adclu;

import java.util.ArrayList;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class Parsed {
    
    @Parameter(names={"greet", "g"}, description = "Takes a String input and greets them.")
    String greetee;

    @Parameter(names = {"diff", "d"}, variableArity = true, description = "Finds the difference between two given files.")
    ArrayList<String> diffFilePaths = new ArrayList<>();
    
    public Parsed( String args[] ) {
        JCommander.newBuilder()
            .addObject(this)
            .build()
            .parse(args);
    }
    
}
