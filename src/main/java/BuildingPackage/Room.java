package BuildingPackage;

public class Room {
    String roomName;

    public Room(String roomName) {
        this.roomName = roomName;
    }

    public String getRoom() {
        return this.roomName;
    }

    public void printRoom() {
        System.out.println(getRoom());
    }

    enum Days {
        SUNDAY,
        MONDAY
    }
}
