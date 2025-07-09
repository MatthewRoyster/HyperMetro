package metro;

import metro.StationLinkedList.StationLinkedList;
import metro.StationLinkedList.StationLinkedList1;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StationLinkedList metro = new StationLinkedList1();

        //Test to see if the file input was correct
        //System.out.println(Arrays.toString(args));

        //Read in the file of stations and add them to
        //the list of stations
        try {
            File file = new File(args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while(reader.ready()){
                metro.add(reader.readLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("Error! Such a file doesn't exist!");
        }catch(IOException e){
            System.out.println("Error! Something went wrong with the file!");
        }

        //Test to validate the list was generated correctly
        //System.out.println(metro.toString());

        int numberOfStations = metro.getNumberOfStations();
        for(int i = 0; i < numberOfStations; i++){
            System.out.println(metro.getPriorStation() + " - " + metro.getCurrentStation() +" - " + metro.getNextStation());
            metro.advanceTraversal();
        }
    }
}
