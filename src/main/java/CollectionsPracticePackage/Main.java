package CollectionsPracticePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person("Merry Christmas", 45, "italian");
        Person person2 = new Person("Happy New Year", 41, "russian");
        Person person3 = new Person("Jingle Bells", 36, "dutch");

        ArrayList<Person> listOfPersons = new ArrayList<Person>();
        listOfPersons.add(person1);
        listOfPersons.add(person2);

        HashMap<PersonType, Person> persons = new HashMap<PersonType, Person>();
        persons.put(PersonType.TEACHER, listOfPersons.get(0));
        persons.put(PersonType.STUDENT, listOfPersons.get(1));

        for(Person i : listOfPersons) {
            System.out.println(i);
        }

        for(Map.Entry<PersonType,Person> entry : persons.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
