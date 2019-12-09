package BuildingPackage;

import java.util.ArrayList;

public class Floors {
    String floorName;
    ArrayList<ConferenceRoom> conferenceRoomsList;
    ArrayList<OfficeRoom> officeRoomsList;
    ArrayList<KitchenRoom> kitchenRoomsList;
    ArrayList<ToiletRoom> toiletRoomsList;
    int numberOfConferenceRooms;
    int numberOfOfficeRooms;
    int numberOfKitchenRooms;
    int numberOfToiletRooms;

    public Floors(String floorName) {
        this.floorName = floorName;
        this.conferenceRoomsList = new ArrayList<ConferenceRoom>();
        this.officeRoomsList = new ArrayList<OfficeRoom>();
        this.kitchenRoomsList = new ArrayList<KitchenRoom>();
        this.toiletRoomsList = new ArrayList<ToiletRoom>();
    }

    public String getFloorName() {
        return this.floorName;
    }

    public void addRooms(int numberOfRooms, Rooms.roomType roomType) {
        for (int i = 0; i<numberOfRooms; i++) {
            if (roomType == Rooms.roomType.CONFERENCE) {
                ConferenceRoom conferenceRoom = new ConferenceRoom("Conference room " + (numberOfConferenceRooms+1));
                this.conferenceRoomsList.add(numberOfConferenceRooms,conferenceRoom);
                this.numberOfConferenceRooms++;
            }
            else if (roomType == Rooms.roomType.OFFICE) {
                OfficeRoom officeRoom = new OfficeRoom("Office room " + (numberOfOfficeRooms+1));
                this.officeRoomsList.add(numberOfOfficeRooms,officeRoom);
                this.numberOfOfficeRooms++;
            }
            else if (roomType == Rooms.roomType.KITCHEN) {
                KitchenRoom kitchenRoom = new KitchenRoom("Kitchen " + (numberOfKitchenRooms+1));
                this.kitchenRoomsList.add(numberOfKitchenRooms,kitchenRoom);
                this.numberOfKitchenRooms++;
            }
            else if (roomType == Rooms.roomType.TOILET) {
                ToiletRoom toiletRoom = new ToiletRoom("Toilet " + (numberOfToiletRooms+1));
                this.toiletRoomsList.add(numberOfToiletRooms,toiletRoom);
                this.numberOfToiletRooms++;
            }
        }
    }

    public void addFurnitureOrAppliances(Rooms.roomType roomType, String roomName, Rooms.furnitureAndAppliancesType furnitureAndAppliancesType, int numberOfItems) {
           if (roomType.equals(Rooms.roomType.CONFERENCE)) {
               for(ConferenceRoom conferenceRoom: conferenceRoomsList) {
                   if (roomName.equals(conferenceRoom.getRoomName())) {
                       if (furnitureAndAppliancesType.equals(Rooms.furnitureAndAppliancesType.SEAT)) {
                           conferenceRoom.addSeats(numberOfItems);
                       }
                       else if (furnitureAndAppliancesType.equals(Rooms.furnitureAndAppliancesType.TELEPRESENCE)) {
                           conferenceRoom.addTelepresence(numberOfItems);
                       }
                       else if (furnitureAndAppliancesType.equals(Rooms.furnitureAndAppliancesType.TV)) {
                           conferenceRoom.addTVs(numberOfItems);
                       }
                       else if (furnitureAndAppliancesType.equals(Rooms.furnitureAndAppliancesType.VIDEOPROJECTOR)) {
                           conferenceRoom.addVideoProjectors(numberOfItems);
                       }
                   }
               }
           }
            else if (roomType.equals(Rooms.roomType.OFFICE)) {
               for (OfficeRoom officeRoom : officeRoomsList) {
                   if (roomName.equals(officeRoom.getRoomName())) {
                       if (furnitureAndAppliancesType.equals(Rooms.furnitureAndAppliancesType.DESK)) {
                           officeRoom.addDesks(numberOfItems);
                       }
                   }
               }
           }
           else if (roomType.equals(Rooms.roomType.KITCHEN)) {
               for (KitchenRoom kitchenRoom : kitchenRoomsList) {
                   if (roomName.equals(kitchenRoom.getRoomName())) {
                       if (furnitureAndAppliancesType.equals(Rooms.furnitureAndAppliancesType.COFFEEMACHINE)) {
                           kitchenRoom.addCoffeeMachines(numberOfItems);
                       }
                       else if (furnitureAndAppliancesType.equals(Rooms.furnitureAndAppliancesType.WATERDISPENSER)) {
                           kitchenRoom.addWaterDispensers(numberOfItems);
                       }
                       else if (furnitureAndAppliancesType.equals(Rooms.furnitureAndAppliancesType.FRIDGE)) {
                           kitchenRoom.addFridges(numberOfItems);
                       }
                   }
               }
           }
    }

    public void printFloor() {
        System.out.println(getFloorName());
        for (ConferenceRoom confRoom : conferenceRoomsList) {
            System.out.print("  - ");
            confRoom.printRoom();
        }
        for (OfficeRoom officeRoom : officeRoomsList) {
            System.out.print("  - ");
            officeRoom.printRoom();
        }
        for (KitchenRoom kitchenRoom : kitchenRoomsList) {
            System.out.print("  - ");
            kitchenRoom.printRoom();
        }
        for (ToiletRoom toiletRoom : toiletRoomsList) {
            System.out.print("  - ");
            toiletRoom.printRoom();
        }
    }

}
