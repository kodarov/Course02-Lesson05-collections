package pro.sky.collections.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.Employee;
import pro.sky.collections.services.EmployeeService;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee/add")
    public String addEmployee(@RequestParam("lastName") String lastName,
                              @RequestParam("firstName") String firstName
    ) {
        Employee employee = new Employee(lastName, firstName);
        employeeService.addEmployee(employee);
        return "Employee added successfully";
    }

    @GetMapping(path = "/employee/delete")
    public String deleteEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName
    ) {
        Employee employee = new Employee(lastName, firstName);
        employeeService.deleteEmployee(employee);
        return "Employee removed successfully";
    }

    @GetMapping(path = "/employee/search")
    public String searchEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName
    ) {
        Employee employee = new Employee(lastName, firstName);
        employeeService.searchEmployee(employee);
        return "Employee found";
    }
}
