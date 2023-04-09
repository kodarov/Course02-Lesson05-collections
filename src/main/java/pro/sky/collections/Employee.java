package pro.sky.collections;

import java.util.Objects;

public class Employee {
    private final String lastName;
    private final String firstName;


    public Employee(String lastName, String firstName) {
        if (lastName.trim().isEmpty() || firstName.trim().isEmpty()) {
            throw new RuntimeException("Отсутствуют полные данные!");
        }
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }

    @Override
    public String toString() {
        return String.format("Работник %s %s", lastName, firstName);
    }
}
