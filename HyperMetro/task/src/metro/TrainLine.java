package metro;

import metro.StationLinkedList.StationLinkedList;
import metro.StationLinkedList.StationLinkedList1;

public class TrainLine {

    private final StationLinkedList stations;
    private final String lineName;

    public TrainLine(String name){
        this.stations = new StationLinkedList1();
        this.lineName = name;
    }

    public StationLinkedList getStations(){
        return this.stations;
    }

    public String getLineName(){
        return this.lineName;
    }

    public void printTrainLine(){
        System.out.println(this.stations.toString());
    }

    public void addStation(String s, int i){
        this.stations.add(s, i);
    }

}
