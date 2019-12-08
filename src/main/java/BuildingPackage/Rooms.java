package BuildingPackage;

public abstract class Rooms {
    String roomName;
    public enum roomType {
        KITCHEN,
        CONFERENCE,
        OFFICE,
        TOILET
    }

    enum furnitureAndAppliancesType {
        SEAT,
        TV,
        VIDEOPROJECTOR,
        TELEPRESENCE,
        DESK,
        COFFEEMACHINE,
        WATERDISPENSER,
        FRIDGE
    }

    public Rooms(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }
    abstract void printRoom();

}
