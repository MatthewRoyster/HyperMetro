package metro;

import java.io.*;

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
    }
}
