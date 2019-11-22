package InheritancePracticePackage;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Joe", "Briggs", "02.06.1991", 12345);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Jane", "Priest", "02.06.1991", 12);

        System.out.println(employee.getName());
        System.out.println(employee.getBirthDate());
        System.out.println(employee.getSalary());

        System.out.println(partTimeEmployee.getName());
        System.out.println(partTimeEmployee.getBirthDate());
        System.out.println(partTimeEmployee.getSalary() );
    }
}
