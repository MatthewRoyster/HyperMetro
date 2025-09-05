package metro;

import java.io.BufferedReader;
import java.io.IOException;

public class JSONTrainLineHandler {

    public static void processJSONFile(BufferedReader r, SubwayMap m){
        try {
            //Read initial open bracket
            r.readLine();

            while(!r.ready()){
                //Get line and then process to get just the name of the line
                String lineName = r.readLine();
                lineName = lineName.trim();
                lineName = lineName.substring(1, lineName.length()-1);
                lineName = lineName.substring(0, lineName.indexOf('"'));

                //Print to verify correct during testing, TODO remove print line
                System.out.println(lineName);

                //Add to the map and then get line to prepare to add stations
                m.addLine(lineName);
                TrainLine line = m.getLine(lineName);

                String station = r.readLine();
                while(!station.contains("}")){
                    //current format = "    "1": "Baker Street",
                    //By split we get two strings "     "1"" and ""Baker Street","
                    //We can trim the first one down and then remove quotes
                    //The second may have spaces in the name so we can remove just the punctuation
                    String[] currentStation = station.split(":");

                    String stationNumber = currentStation[0].substring(1, currentStation[0].length()-2);
                    String stationName = currentStation[1].substring(1, currentStation[1].length()-1);


                    station = r.readLine();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*TODO The buffered reader should represent a JSON text file
    the goal will be to read the file and generate the appropriate
    lines and stations based on a format.
     */

}
