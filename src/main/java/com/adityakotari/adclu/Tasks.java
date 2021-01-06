package com.adityakotari.adclu;

import java.util.ArrayList;

public class Tasks {

    public static void run(Parsed parsed){
        if(parsed.taskArgs.get(0).equals("show")
                ||parsed.taskArgs.get(0).equals("s")){
            show();
        }
        else if(parsed.taskArgs.get(0).equals("add")
                ||parsed.taskArgs.get(0).equals("a")){
            add(parsed.taskArgs);
        }
        else if(parsed.taskArgs.get(0).equals("delete")
                ||parsed.taskArgs.get(0).equals("d")
                ||parsed.taskArgs.get(0).equals("done")){
            delete(parsed.taskArgs);
        }
        else{
            System.out.println("Wrong input parameters.");
        }
    }

    static void show(){
        ArrayList<String> taskList=SqlFuncs.query();
        for(int i=1; i<=taskList.size(); i++){
            System.out.println(i+" - "+taskList.get(i-1));
        }
        System.out.println();
    }

    static void add(ArrayList<String> taskArgs){
        String task="";
        
        for(int i=1; i<taskArgs.size(); i++){
            task=task+taskArgs.get(i)+" ";
        }
        //System.out.println(task);
        try{
            String taskCommand="INSERT INTO tasks (name)\n"
                +" VALUES ('"+task+"');";
            SqlFuncs.execute(taskCommand);
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Operation attempted.");
    }

    static void delete(ArrayList<String> taskArgs){
        String taskNumber=taskArgs.get(1);
        //System.out.println(task);
        try{
            String taskCommand="DELETE FROM tasks \n"
                +" WHERE id='"+taskNumber+"';";
            SqlFuncs.execute(taskCommand);
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Operation attempted.");
    }
}
