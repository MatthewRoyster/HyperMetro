package metro;

import java.util.ArrayList;
import java.util.List;

public class SubwayMap {

    private List<TrainLine> lines;

    public SubwayMap(){
        this.lines = new ArrayList<TrainLine>();
    }

    public void addLine(String name){
        this.lines.add(new TrainLine(name));
    }

    /**
     * Searches for and returns the train line object based
     * upon searching for a name. Will return null if not found
     *
     * @param name A string of the train line name to retrieve.
     * @return Returns the TrainLine object whose name matches
     * the param name, WILL return null if not found.
     */
    public TrainLine getLine(String name){
        TrainLine line = null;
        for(int i = 0; i < this.lines.size(); i++){
            if(this.lines.get(i).getLineName().equals(name)){
                line = this.lines.get(i);
            }
        }
        return line;
    }

    /**
     * Gets the total number of train lines created
     *
     * @return Returns the number of train lines in the subway list
     */
    public int getNumberOfLine(){
        return this.lines.size();
    }
}
