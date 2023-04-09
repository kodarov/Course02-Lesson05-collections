package pro.sky.collections.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.collections.Employee;
import pro.sky.collections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections.exceptions.EmployeeNotFoundException;
import pro.sky.collections.exceptions.EmployeeStorageIsFullException;
import pro.sky.collections.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("lastName") String lastName,
                                @RequestParam("firstName") String firstName
    ) {
        Employee employee = new Employee(lastName, firstName);
        return employeeService.addEmployee(employee);
    }

    @GetMapping(path = "/delete")
    public Employee deleteEmployee(@RequestParam("lastName") String lastName,
                                   @RequestParam("firstName") String firstName
    ) {
        Employee employee = new Employee(lastName, firstName);
        return employeeService.deleteEmployee(employee);
    }

    @GetMapping(path = "/search")
    public Employee searchEmployee(@RequestParam("lastName") String lastName,
                                   @RequestParam("firstName") String firstName
    ) {
        Employee employee = new Employee(lastName, firstName);
        return employeeService.searchEmployee(employee);
    }

    @GetMapping(path = "/print")
    public List<Employee> printEmployees() {
        return employeeService.print();
    }

    @ExceptionHandler(EmployeeStorageIsFullException.class)
    public ResponseEntity<String> handException(EmployeeStorageIsFullException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("ArrayIsFull");
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handException(EmployeeNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("EmployeeNotFound");
    }

    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public ResponseEntity<String> handException(EmployeeAlreadyAddedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("EmployeeAlreadyAdded");
    }
}
