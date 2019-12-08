package BuildingPackage;

public class OfficeRoom extends Rooms {
    int numberOfDesks;

    public OfficeRoom(String roomName) {
        super(roomName);
    }

    public void addDesks(int numberOfDesks) { this.numberOfDesks += numberOfDesks; }
    public String getRoomName() {
        return super.roomName;
    }
    public int getNumberOfDesks() {
        return numberOfDesks;
    }

    @Override
    void printRoom() {
        System.out.println(getRoomName());
        if (numberOfDesks>0) { System.out.println("    - " + getNumberOfDesks() + " Desks"); }
    }

}
