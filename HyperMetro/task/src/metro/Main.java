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
                    String[] options = processOptions(userOptions);
                    metro.getLine(options[0]).addStation(options[1]);
                } else if (userInput.equals("/add-head")) {
                    String[] options = processOptions(userOptions);
                    metro.getLine(options[0]).addStation(options[1], 1);
                } else if (userInput.equals("/remove")) {
                    String[] options = processOptions(userOptions);
                    metro.getLine(options[0]).removeStation(options[1]);
                } else if (userInput.equals("/output")) {

                    //Check to see if the input is a multi word option
                    //If it is strip the quotes off before calling output
                    if(userOptions.contains("\"")){
                        userOptions = userOptions.substring(1, userOptions.length()-1);
                    }

                    StationLinkedList tl = metro.getLine(userOptions).getStations();
                    int numberOfStations = tl.getNumberOfStations();

                    for(int i = 0; i < numberOfStations; i++){
                        System.out.println(tl.getPriorStation() + " - " + tl.getCurrentStation() + " - " + tl.getNextStation());
                        tl.advanceTraversal();
                    }
                    tl.restartTraversal();

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
    private static String[] processOptions(String str){
        String[] options = new String[2];

        //System.out.println(str);
        //Process and get line name
        if(str.charAt(0) == '"'){
            str = str.substring(1);
            options[0] = str.substring(0, str.indexOf('"'));
            str = str.substring(options[0].length()+2);
        }else{
            options[0] = str.substring(0, str.indexOf(' '));
            str = str.substring(options[0].length()+1);
        }
        //System.out.println(str);


        //Process and get station name
        if(str.charAt(0) == '"'){
            str = str.substring(1);
            options[1] = str.substring(0, str.indexOf('"'));
        }else{
            options[1] = str;
        }

        //System.out.println(Arrays.toString(options));
        return options;

        /*
        example 1 of string breakdown
        "moose" "moose" *option with both being quotes
        moose" "moose" * remove first quote
        "moose" * remove length and the end quote and space
        moose" * remove quote and get till next quote

        example 2 with no quotes
        moose moose * go straight to extracting string
        moose * remove word and the space
         */
    }
}
