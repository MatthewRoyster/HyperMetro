package metro;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

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
}
