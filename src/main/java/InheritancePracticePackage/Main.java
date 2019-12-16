package InheritancePracticePackage;

//        Create a class called Person with the following properties: firstName, lastName, address, city, country, birthDate.
//        By printing the object you can print their full name and their birth date.
//        Create a subclass of the Person class, called Employee. The employee has a salary.
//        By printing the object you can also print their salary in addition to what’s printed for a person.
//        Create a subclass of Employee, called PartTimeEmployee. The part time employee’s salary is -25% of the full time employee’s.
//        In another class, create the main method that will create each type of employees and print them.

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
