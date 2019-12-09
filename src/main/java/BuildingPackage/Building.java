package BuildingPackage;

import java.util.ArrayList;

public class Building {
    String buildingName;
    ArrayList<Floors> floorsList;
    int numberOfFloors;
    int floorIndex;
    String floorName = "Floor" + floorIndex;
    Floors floors = new Floors(floorName);

    public Building(String buildingName, int numberOfFloors) {
        this.buildingName = buildingName;
        this.floorsList = new ArrayList<Floors>();
        addFloors(numberOfFloors);
    }

    public void addFloors(int numberOfFloors) {
        int startingIndex = floorsList.size();
        for (int i = 0; i<numberOfFloors; i++) {
            Floors floor = new Floors("Floor" + startingIndex);
            this.floorsList.add(startingIndex, floor);
            startingIndex++;
        }
        this.numberOfFloors =+ numberOfFloors;
    }

    public void addRooms(String floorName, int numberOfRooms, Rooms.roomType roomType) {
        for (Floors floor : floorsList) {
            if (floorName.equals(floor.getFloorName())) {
                floor.addRooms(numberOfRooms, roomType);
            }
        }
    }

    public void addFurnitureOrAppliances(String floorName, Rooms.roomType roomType, String roomName, Rooms.furnitureAndAppliancesType furnitureAndAppliancesType, int numberOfItems) {
        for (Floors floor : floorsList) {
            if (floorName.equals(floor.getFloorName())) {
                floor.addFurnitureOrAppliances(roomType, roomName, furnitureAndAppliancesType, numberOfItems);
            }
        }
    }

    public Floors getFloor(int index) {
        return floorsList.get(index);
    }

    public void printFloors() {
        for (Floors fl : this.floorsList) {
            this.floors = fl;
            System.out.print("  - ");
            this.floors.printFloor();
        }
    }


    public void printBuilding() {
        System.out.println(buildingName + " building has the following structure:");
        for(int i = 0; i < floorsList.size(); i++) {
            floorsList.get(i).printFloor();
        }
    }

}
