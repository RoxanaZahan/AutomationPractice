package BuildingPackage;

public class KitchenRoom extends Rooms {
    int numberOfCoffeeMachines;
    int numberOfWaterDispensers;
    int numberOfFridges;

    public KitchenRoom(String roomName) {
        super(roomName);
    }

    public void addCoffeeMachines(int numberOfCoffeeMachines) { this.numberOfCoffeeMachines += numberOfCoffeeMachines; }
    public void addWaterDispensers(int numberOfWaterDispensers) { this.numberOfWaterDispensers += numberOfWaterDispensers; }
    public void addFridges(int numberOfFridges) { this.numberOfFridges += numberOfFridges; }

    public String getRoomName() { return super.roomName; }
    public int getNumberOfCoffeeMachines() {
        return numberOfCoffeeMachines;
    }
    public int getNumberOfWaterDispensers() {
        return numberOfWaterDispensers;
    }
    public int getNumberOfFridges() { return numberOfFridges; }

    @Override
    void printRoom() {
        System.out.println(getRoomName());
        if (numberOfCoffeeMachines>0) { System.out.println("    - " + getNumberOfCoffeeMachines() + " Coffee Machines"); }
        if (numberOfWaterDispensers>0) { System.out.println("    - " + getNumberOfWaterDispensers() + " Water Dispensers"); }
        if (numberOfFridges>0) { System.out.println("    - " + getNumberOfFridges() + " Fridges"); }
    }
}
