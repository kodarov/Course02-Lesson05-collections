package pro.sky.collections.services;

import org.springframework.stereotype.Service;
import pro.sky.collections.Employee;
import pro.sky.collections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections.exceptions.EmployeeNotFoundException;
import pro.sky.collections.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
    private static int SIZE = 4; //искуственно ограничиваем List
    private final List<Employee> employeeList = new ArrayList<>(SIZE);

    public Employee addEmployee(Employee employee) {
        if (employeeList.size() < SIZE) {
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).equals(employee)) {
                    throw new EmployeeAlreadyAddedException("Employee exists!");
                }
            }
        } else throw new EmployeeStorageIsFullException("Book overflow!");
        employeeList.add(employee);
        return employee;
    }

    public Employee deleteEmployee(Employee employee) {
/*        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee nextEmployee = employeeIterator.next();
            if (nextEmployee.equals(employee)) {
                employeeIterator.remove();
                return employee;
            }
        }*/
        if (employeeList.remove(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    public Employee searchEmployee(Employee employee) {
/*        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).equals(employee)) {
                return employee;
            }
        }*/
        if (employeeList.contains(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    public List<Employee> print() {
        return new ArrayList<>(employeeList);
    }
}
