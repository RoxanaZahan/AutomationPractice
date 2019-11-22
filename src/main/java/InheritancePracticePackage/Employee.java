package InheritancePracticePackage;

public class Employee extends Person {
    double salary;

    public Employee(String firstName, String lastName, String birthDate, double salary) {
        super(firstName, lastName, birthDate);
        this.salary = salary;
    }

    protected double getSalary(){
        return salary;
    }
}
