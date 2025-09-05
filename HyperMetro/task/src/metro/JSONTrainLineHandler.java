package metro;

import java.io.BufferedReader;
import java.io.IOException;

public class JSONTrainLineHandler {

    public static void processJSONFile(BufferedReader r, SubwayMap m){
        //System.out.println("Processing JSON File");
        try {
            //Read initial open bracket
            r.readLine();
            //Read the first line name
            String lineName = r.readLine();

            while(r.ready()){
                //Get line and then process to get just the name of the line
                lineName = lineName.trim();
                lineName = lineName.substring(1, lineName.length()-1);
                lineName = lineName.substring(0, lineName.indexOf('"'));

                //Print to verify correct during testing
                //System.out.println(lineName);

                //Add to the map and then get line to prepare to add stations
                m.addLine(lineName);
                TrainLine line = m.getLine(lineName);

                String station = r.readLine();
                while(!station.contains("}")){
                    //current format = "    "1": "Baker Street",
                    //By split we get two strings "     "1"" and ""Baker Street","
                    //We can trim the first one down and then remove quotes
                    //The second may have spaces in the name so we can't remove just the punctuation
                    String[] currentStation = station.split(":");
                    //System.out.println(Arrays.toString(currentStation));

                    //Get the string down to just the number
                    String stationNumber = currentStation[0].trim();
                    stationNumber = stationNumber.substring(1, stationNumber.length()-1);

                    //There may be a comma at the end so we will pull the whole substring and then remove based on
                    //location of the ending quotation mark. The first substring will remove the starting one
                    String stationName = currentStation[1];
                    stationName = stationName.substring(stationName.indexOf('"')+1);
                    //System.out.println(stationName);
                    stationName = stationName.substring(0, stationName.indexOf('"'));
                    //System.out.println(stationName);

                    //Sample print statement in order to validate during tests.
                    //System.out.println("Stop Number: " + stationNumber + ", Station Name: " + stationName);

                    //Add the station name and number to the train line
                    line.addStation(stationName, Integer.parseInt(stationNumber));

                    //Read next line, if the next line contains a curly brace then done with this line
                    //otherwise repeat and process that station
                    station = r.readLine();
                }

                //Read either the final brace or next line name
                lineName = r.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
