package BuildingPackage;

import java.util.ArrayList;

public class Building {

    private ArrayList<Floor> floorsList = new ArrayList<Floor>();
    private Floor floor;



    public void addFloor(String floorName) {
        Floor floor = new Floor(floorName);
        this.floorsList.add(floor);
    }

    public void addFloor(int numberOfFloors) {
        int startingIndex = floorsList.size();
        for (int i = 0; i<numberOfFloors; i++) {
            Floor floor = new Floor("Floor" + startingIndex);
            this.floorsList.add(startingIndex, floor);
            startingIndex++;
        }
    }

    public Floor getFloor(int index) {
        return floorsList.get(index);
    }

    public void printFloors() {
        for (Floor fl : this.floorsList) {
            this.floor = fl;
            System.out.print("  - ");
            this.floor.printFloor();
        }
    }


    public void printBuilding() {
        System.out.println("My building has the following structure:");
        printFloors();
    }

}
