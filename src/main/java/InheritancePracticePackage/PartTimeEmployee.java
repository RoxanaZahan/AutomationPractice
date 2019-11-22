package InheritancePracticePackage;

public class PartTimeEmployee extends Employee {

    private double partSalary;

    public PartTimeEmployee(String firstName, String lastName, String birthDate, double salary) {
        super(firstName, lastName, birthDate, salary);
    }

    public double getSalary() {
        this.partSalary = salary - (salary * 0.25);
        return partSalary;
    }
}
