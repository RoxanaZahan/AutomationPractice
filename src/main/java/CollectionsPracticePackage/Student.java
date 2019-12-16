package CollectionsPracticePackage;

public class Student extends Person {
    public Student(String name, int age, String nationality) {
        super(name, age, nationality);
    }

    public String toString() {
        return String.format("Name " + name + ", " + "age " + age + ", " + "nationality " + nationality);
    }
}
