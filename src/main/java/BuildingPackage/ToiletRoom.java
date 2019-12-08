package BuildingPackage;

public class ToiletRoom extends Rooms{

    public ToiletRoom(String roomName) {
        super(roomName);
    }

    public String getRoomName() {
        return super.roomName;
    }

    @Override
    void printRoom() {
        System.out.println(getRoomName());
    }
}
