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
        for (int i = 0; i < numberOfFloors; i++) {
            this.floorsList.add(this.floorIndex, new Floors(this.floorName));
            this.floorIndex++;
            System.out.println(this.floorName);
        }
        this.numberOfFloors =+ numberOfFloors;
    }

    public String getFloors() {
        return floorsList.toString();
    }


    public void printBuilding() {
        System.out.println(buildingName + " building has the following structure:");
        for(int i = 0; i < floorsList.size(); i++) {
            floorsList.get(i).printFloor();
        }
    }

}
