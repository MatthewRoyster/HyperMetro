package metro.StationLinkedList;

import java.util.ArrayList;
import java.util.List;

public class StationLinkedList1 implements StationLinkedList{


    private final List<String> stations;

    private int traversalCounter = 1;

    public StationLinkedList1() {
        this.stations = new ArrayList<>();
        this.stations.add("depot");
        this.stations.add("depot");
    }

    public int getSize(){
        return this.stations.size();
    }

    public int getNumberOfStations(){
        return this.stations.size()-2;
    }

    public String getHead(){
        return !this.stations.isEmpty() ? this.stations.get(1) : "";
    }

    public String getTail(){
        return !this.stations.isEmpty() ? this.stations.get(this.stations.size()-2) : "";
    }

    public boolean isEmpty(){
        return this.stations.isEmpty();
    }

    public String toString(){
        return this.stations.toString();
    }

    public String getStation(int index){
        return this.stations.size() > index ? this.stations.get(index) : "";
    }
    public void add(String station){
        this.stations.add(this.stations.size()-1, station);
    }

    public void add(String station, int index){
        this.stations.add(index, station);
    }

    public void removeStation(int index){
        this.stations.remove(index);
    }
    public void removeStation(String station){
        this.stations.remove(station);
    }

    public String getCurrentStation() {
        return countValidator(this.traversalCounter) ? this.stations.get(this.traversalCounter) : "";
    }

    public String getPriorStation() {
        return countValidator(this.traversalCounter-1) ? this.stations.get(this.traversalCounter-1) : "";
    }

    public String getNextStation() {
        return countValidator(this.traversalCounter+1) ? this.stations.get(this.traversalCounter+1) : "";
    }

    private boolean countValidator(int count){
        return this.stations.size() > count && count >= 0;
    }

    public void restartTraversal(){
        this.traversalCounter = 1;
    }

    public void advanceTraversal(){
        this.traversalCounter++;
    }

    public void recallTraversal(){
        this.traversalCounter--;
    }
}
