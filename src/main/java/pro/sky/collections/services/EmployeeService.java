package pro.sky.collections.services;

import org.springframework.stereotype.Service;
import pro.sky.collections.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void deleteEmployee(Employee employee) {
            employeeList.remove(employee);
    }
    public String searchEmployee(Employee employee) {
        if (employeeList.contains(employee)){
            return "Найден "+ employee.toString();
        }
        return "Работник не найден";
    }


}
