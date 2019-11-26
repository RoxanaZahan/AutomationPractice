package BuildingPackage;

import java.util.ArrayList;

public class Building {
    String buildingName;
    ArrayList<Floors> floorsList;
    int numberOfFloors;
    int floorIndex;
    String floorName = "Floor" + floorIndex;


    public Building(String buildingName, int numberOfFloors) {
        this.buildingName = buildingName;
        this.floorsList = new ArrayList<Floors>();
        addFloors(numberOfFloors);
    }

    public void addFloors(int numberOfFloors) {
        for (int i = 0; i < numberOfFloors; i++) {
            floorsList.add(floorIndex, new Floors(this.buildingName, this.numberOfFloors, this.floorName));
            floorIndex++;
        }
        this.numberOfFloors =+ numberOfFloors;
    }

    public String getFloors() {
        return floorsList.toString();
    }


    public void printBuilding() {
        System.out.println(buildingName + " building has the following structure:");
    }

}
