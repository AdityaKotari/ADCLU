package com.adityakotari.adclu;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Diff {
    static int table[][];

    public static void run(Parsed parsed) throws IOException{
        
        if(parsed.diffFilePaths.size()!=2){
            System.out.println("Error: Wrong number of file paths entered.");
            return;
        }

        List<String> fileA = readFileInList(parsed.diffFilePaths.get(0)), 
                fileB = readFileInList(parsed.diffFilePaths.get(1));
        
        CreateLcsTable(fileA, fileB);
        System.out.printf("\nFilepaths:\n"+parsed.diffFilePaths.get(0)
                +"\n"+parsed.diffFilePaths.get(1)+"\n\nDiff:\n");
        printDiff(fileA, fileB, fileA.size(), fileB.size());
    }
    
    /*
    Implementation and optimization thanks to the wikipedia article on LCS. 
    */
    static void CreateLcsTable(List<String> a, List<String> b){
        
        //The table is 1-index based while s1, s2 are 0-index based.
        table = new int[a.size()+1][b.size()+1];
        
        /*
        1. if chars are equal, then table(i, j) = 1+table(i-1, j-1)
        2. if chars are unequal, then table(i, j) = Max(table(i-1, j), table(i, j-1))
        */
        for(int i=1; i<=a.size(); i++){
            for(int j=1; j<=b.size(); j++){ 
                
                if(a.get(i-1).equals(b.get(j-1))){
                    table[i][j] = 1 + table[i-1][j-1];
                }
                else{
                    if(table[i-1][j]>table[i][j-1]){
                        table[i][j]=table[i-1][j];
                    }
                    else{
                        table[i][j]=table[i][j-1];
                    }
                }
            }
        }
        return;
    }

    static void printDiff(List<String> a, List<String> b, int i, int j){
        if(i>0&&j>0&&a.get(i-1).equals(b.get(j-1))){
            printDiff(a, b, i-1, j-1);
            System.out.println("  " + a.get(i-1));
        }
        else if(j>0&&(i==0||table[i][j-1]>=table[i-1][j])){
            printDiff(a, b, i, j-1);
            System.out.println("+ " + b.get(j-1));
        }
        else if(i>0&&(j==0||table[i][j-1]<table[i-1][j])){
            printDiff(a, b, i-1, j);
            System.out.println("- " + a.get(i-1));
        }
        else{
            System.out.print("");
        }
    }
    

    public static List<String> readFileInList(String fileName)throws IOException{ 
  
        List<String> lines = Collections.emptyList(); 
        try{ 
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
        } 
        catch(IOException e){ 
            e.printStackTrace(); 
    } 
    return lines; 
  } 
}
