package com.adityakotari.adclu;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class App {
    @Parameter(names={"greet", "g"}, description = "Takes a String input and greets them.")
    String greetee="";
    public static void main( String[] args ) {
        App app = new App();
        JCommander.newBuilder()
            .addObject(app)
            .build()
            .parse(args);
        app.run();
    }
    public void run() {
        if(this.greetee!="")
            System.out.println("Hello "+greetee+"!");
        else
            System.out.println( "Maven is hard... :(" );
    }
}
