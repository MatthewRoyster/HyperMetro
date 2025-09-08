package metro.StationLinkedList;

public interface StationLinkedList {

    /**
     * Gets the first station in the list, the depot will not be counted as
     * a station for this methods purpose
     *
     * @return Returns the first station not counting the depot, location 1,
     * may also return an empty string if the list is empty.
     */
    String getHead();

    /**
     * Gets the last station in the list not counting the depot
     *
     * @return Returns the last station in the list, returns empty string
     * in the event the list is empty.
     */
    String getTail();

    void add(String station);

    void add(String station, int index);

    String getStation(int index);

    /**
     *This method will return the size of the list, ie the number of
     * stations contained within. It will be removing the two depots
     * from the list size and will NOT be counted in the return value.
     *
     * @return Returns the number of stations maintained within the list
     */
    int getNumberOfStations();

    /**
     *
     * @return Returns the entire stations size including depots
     */
    int getSize();

    boolean isEmpty();

    String toString();

    void removeStation(String station);

    void removeStation(int index);

    /**
     * Gets the current station based upon an internal counting method. Traversal
     * will begin at the depot.
     *
     * @return Returns the current station in the traversal, will return an empty
     * string if the internal counter is beyond the length of the list.
     */
    String getCurrentStation();

    /**
     *Returns the previous station visited by the traversal.
     *
     * @return Returns the previous station in the traversal, will return an
     * empty string if the counter is before the beginning or past the end.
     */
    String getPriorStation();

    /**
     * Gets the next station based upon an internal counting method. Traversal
     * will return the final depot in the list.
     *
     * @return Returns the next station in the traversal, will return an
     * empty string if beyond the list size.
     */
    String getNextStation();

    /**
     * This method resets the internal traversal counter back to the
     * first station. This effectively makes the counter 1 while the depot
     * is location 0.
     */
    void restartTraversal();

    /**
     * Advances the traversal counter by one, Effectively moving to
     * the next station in the list.
     */
    void advanceTraversal();

    /**
     * Rewinds the traversal counter by one, Effectively going back
     * to the previous station in the list.
     */
    void recallTraversal();

}
