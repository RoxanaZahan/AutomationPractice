package BuildingPackage;

//        Atat de dinamica trebuie sa fie cladirea
//        incat daca eu ma decid suddenly sa iti zic, ok, we should add like another floor or some office space or some desks or whatever
//        sa pot sa fac asta doar apeland niste metode si atat.
//        Nimic care vine hardcodat din variabile.
//        Totul, dar absolut totul trebuie sa fie parametrizat.
//        eu ma astept ca in clasa de test sa ai astfel de metode
//        building() - n-are param ca e doar 1
//        floors() - parametrizata, sa vedem, poate vreau sa mai adaug ceva floors
//        number of floors () in floors() parametrizata, daca vreau sa mai adaug office spaces etc etc.
//        Plus, toate tipurile de rooms, kitchen etc etc ... sa aiba metode care sa imi intoarca ce elemente vreau eu sa contina
//        acele rooms.
//        absolut tot ce se poate "schimba" modifica, chiar raportandu-ne la o situatia din realitate, vreau ca eu "END USER" sa pot sa dau ca si argument sa specific toate aceste detalii
//        Poti evident la asta cu rooms sa te inspiri de unde vrei tu .
//        Nu ma intereseaza, oricum
//        n-o sa ai sursa de inspiratie pentru asa ceva.
//        e ceva destul de complex from OOP perspectiv
//        Tema este mai mult sa te ajute pe tine sa prinzi aceste principii la un nivel de complexitate mai ridicat.
//        Ca sa poti privi toate aceste aspecte "project-wise" si sa poti transpune cladirea asta intr-un proiect POM/auto

public class Main {

    public static void main(String[] args) {
        Building building = new Building();


        building.addFloor("Floor0");
        building.addFloor("Floor1");
        building.addFloor(3);
        building.printBuilding();
        building.getFloor(0).addRoom("Room1");
        Room.Days day = Room.Days.MONDAY;






    }
}
