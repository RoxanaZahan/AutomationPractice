package CollectionsPracticePackage;

public class Teacher extends Person {
    public Teacher(String name, int age, String nationality) {
        super(name, age, nationality);
    }

    public String toString() {
        return String.format("Name " + name + ", " + "age " + age + ", " + "nationality " + nationality);
    }
}
