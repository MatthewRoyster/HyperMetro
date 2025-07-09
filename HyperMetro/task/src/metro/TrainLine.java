package metro;

import metro.StationLinkedList.StationLinkedList;
import metro.StationLinkedList.StationLinkedList1;

import java.util.ArrayList;
import java.util.List;

public class TrainLine {

    private StationLinkedList stations;
    private String lineName;

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

}
