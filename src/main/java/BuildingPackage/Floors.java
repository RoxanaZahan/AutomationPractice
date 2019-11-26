package BuildingPackage;

import java.util.ArrayList;

public class Floors extends Building{
    String floorName;

    public Floors(String buildingName, int numberOfFloors, String floorName) {
        super(buildingName, numberOfFloors);
        this.floorName = floorName;
    }

    public String getFloor() {
        return this.floorName;
    }

    public void printFloor() {
        System.out.println("   - " + getFloor());
    }

}
