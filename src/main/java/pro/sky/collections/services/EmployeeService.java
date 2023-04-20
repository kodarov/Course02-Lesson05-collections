package pro.sky.collections.services;

import org.springframework.stereotype.Service;
import pro.sky.collections.Employee;
import pro.sky.collections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections.exceptions.EmployeeNotFoundException;
import pro.sky.collections.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private static int SIZE = 4; //искуственно ограничиваем Map
    private final Map<String, Employee> employeeMap = new HashMap<>(SIZE);
    private String getKey(Employee employee){
        return employee.getLastName() + " " + employee.getFirstName();
    }

    /*    public Employee addEmployee(Employee employee) {
            if (employeeMap.size() < SIZE) {
                for (int i = 0; i < employeeMap.size(); i++) {
                    if (employee.get(i).equals(employee)) {
                        throw new EmployeeAlreadyAddedException("Employee exists!");
                    }
                }
            } else throw new EmployeeStorageIsFullException("Book overflow!");
            employee.add(employee);
            return employee;
        }*/
    public Employee addEmployee(Employee employee) {
        if (employeeMap.size() < SIZE) {
            if (employeeMap.containsValue(employee)) {
                throw new EmployeeAlreadyAddedException("Employee exists!");
            }
        } else throw new EmployeeStorageIsFullException("Book overflow!");
        employeeMap.put(getKey(employee), employee);
        return employee;
    }

    public Employee deleteEmployee(Employee employee){
        if (employeeMap.remove(getKey(employee)) != null) {
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    public Employee searchEmployee(Employee employee){
        if (employeeMap.containsValue(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    public Map<String, Employee> print() {
        return new HashMap<>(employeeMap);
    }
}
