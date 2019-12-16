package CollectionsPracticePackage;

public class Person {
    String name;
    int age;
    String nationality;

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public String toString() {
        return String.format("Name " + name + ", " + "age " + age + ", " + "nationality " + nationality);
    }

}
