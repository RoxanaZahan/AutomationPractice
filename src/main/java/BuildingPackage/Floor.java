package BuildingPackage;

import java.util.ArrayList;


public class Floor {
    String floorName;
    private ArrayList<Room> roomsList = new ArrayList<Room>();
    private Room room;

    public Floor(String floorName) {
        this.floorName = floorName;
    }

    public String getFloor() {
        return this.floorName;
    }

    public void printFloor() {
        System.out.println(getFloor());
    }

    public void addRoom(String roomName) {
        Room room = new Room(roomName);
        this.roomsList.add(room);
    }
//
//    public void addRoom(int numberOfRooms) {
//        int startingIndex = floorsList.size();
//        for (int i = 0; i<numberOfFloors; i++) {
//            Floor floor = new Floor("Floor" + startingIndex);
//            this.floorsList.add(startingIndex, floor);
//            startingIndex++;
//        }
//    }
//
//    public Floor getFloor(int index) {
//        return floorsList.get(index);
//    }
//
//    public void printFloors() {
//        for (Floor fl : this.floorsList) {
//            this.floor = fl;
//            System.out.print("  - ");
//            this.floor.printFloor();
//        }
//    }

}
