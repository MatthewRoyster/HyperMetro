package metro;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import metro.StationLinkedList.StationLinkedList;

import static metro.JSONTrainLineHandler.processJSONFile;

public class Main {
    public static void main(String[] args) {
        SubwayMap metro = new SubwayMap();

        //Test to see if the file input was correct
        //System.out.println(Arrays.toString(args));

        //Read in the file of stations and add them to
        //the list of stations
        try {
            File file = new File(args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            processJSONFile(reader, metro);


        }catch (FileNotFoundException e){
            System.out.println("Error! Such a file doesn't exist!");
        }

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        while(!userInput.equals("/exit")){
            String userOptions = userInput.substring(userInput.indexOf(" ")+1);
            userInput = userInput.substring(0, userInput.indexOf(" "));

            try {
                if (userInput.equals("/append")) {

                } else if (userInput.equals("/add-head")) {

                } else if (userInput.equals("/remove")) {

                } else if (userInput.equals("/output")) {
                    //Check to see if the input is a multi word option
                    //If it is strip the quotes off before calling output
                    if(userOptions.contains("\"")){
                        userOptions = userOptions.substring(1, userOptions.length()-1);
                    }

                    metro.getLine(userOptions).printTrainLine();

                } else if(!userInput.equals("/exit")) {
                    System.out.println("Invalid command");
                }
            }
            catch(Exception e){
                System.out.println("Invalid command");
            }

            userInput = input.nextLine();
        }

    }

    //Process input options to separate out train line and station name
    private String[] processOptions(String str){
        String[] options = new String[2];

        //Process and get line name
        if(str.charAt(0) == '"'){
            str = str.substring(1);
            options[0] = str.substring(0, str.charAt('"'));
        }else{
            options[0] = str.substring(0, str.charAt(' '));
        }

        //Remove the line name from the input
        str = str.substring(options[0].length());

        //Process and get station name
        if(str.charAt(0) == '"'){
            
        }else{

        }
        return options;
    }
}
