package com.adityakotari.adclu;

import java.io.IOException;

public class App {
     
    public static void main( String[] args )throws IOException {
        
        Parsed parsed = new Parsed( args );
        run(parsed);
    }

    
    public static void run(Parsed parsed) throws IOException{

        if(parsed.greetee!=null)
            System.out.println("Hello "+parsed.greetee+"!");
        else if(!parsed.diffFilePaths.isEmpty())
            Diff.run(parsed);
        else{
            Tasks.run(parsed);
        }
    }
}
