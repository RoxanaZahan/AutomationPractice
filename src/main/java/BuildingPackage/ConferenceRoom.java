package BuildingPackage;

public class ConferenceRoom extends Rooms {
    int numberOfSeats;
    int numberOfTVs;
    int numberOfVideoProjectors;
    int numberOfTelepresence;

    public ConferenceRoom(String roomName) {
        super(roomName);
    }

    public void addSeats(int numberOfSeats) { this.numberOfSeats += numberOfSeats; }
    public void addTVs(int numberOfTVs) { this.numberOfTVs += numberOfTVs; }
    public void addVideoProjectors(int numberOfVideoProjectors) { this.numberOfVideoProjectors += numberOfVideoProjectors; }
    public void addTelepresence(int numberOfTelepresence) { this.numberOfTelepresence += numberOfTelepresence; }

    public String getRoomName() { return super.roomName; }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public int getNumberOfTVs() {
        return numberOfTVs;
    }
    public int getNumberOfVideoProjectors() { return numberOfVideoProjectors; }
    public int getNumberOfTelepresence() { return numberOfTelepresence; }

    @Override
    void printRoom() {
        System.out.println(getRoomName());
        if (numberOfSeats>0) { System.out.println("    - " + getNumberOfSeats() + " Seats"); }
        if (numberOfTVs>0) { System.out.println("    - " + getNumberOfTVs() + " TV"); }
        if (numberOfVideoProjectors>0) { System.out.println("    - " + getNumberOfVideoProjectors() + " Video Projector"); }
        if (numberOfTelepresence>0) { System.out.println("    - " + getNumberOfTelepresence() + " Telepresence"); }
    }
}
