package pro.sky.employees2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/all")
    public String listOfEmployees() {
        List<Employee> listOfEmployee = null;

        try {
            listOfEmployee = employeeService.listOfEmployees();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee.toString();
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("lastName") String lastName,
                              @RequestParam("firstName") String firstName,
                              @RequestParam("department") Integer department,
                              @RequestParam("salary") Integer salary) throws EmployeeAlreadyAddedException {
        Employee listOfEmployee = null;

        try {
            listOfEmployee = employeeService.addEmployee(lastName, firstName, department, salary);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee.toString();
    }

    @GetMapping(path = "/delete")
    public String deleteEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("department") Integer department,
                                 @RequestParam("salary") Integer salary) throws EmployeeNotFoundException {
        Employee listOfEmployee = null;

        try {
            listOfEmployee = employeeService.deleteEmployee(lastName, firstName, department, salary);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee.toString();
    }

    @GetMapping(path = "/find")
    public String toFindEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName) throws EmployeeNotFoundException {
        Employee listOfEmployee = null;

        try {
            listOfEmployee = employeeService.toFindEmployee(lastName, firstName);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee.toString();
    }

    @GetMapping(path = "/with")
    public String withdrawalOfEmployees() {
        List<Employee> listOfEmployees = null;

        try {
            listOfEmployees = employeeService.withdrawalOfEmployees();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployees.toString();
    }

    @GetMapping(path = "/department/max-salary")
    public String maxSalary(@RequestParam("department-max") Integer department) {
        Employee listOfEmployee = null;

        try {
            listOfEmployee = employeeService.maxSalary(department);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee.toString();
    }

    @GetMapping(path = "/department/min-salary")
    public String minSalary(@RequestParam("department-min") Integer department) {
        Employee listOfEmployee = null;

        try {
            listOfEmployee = employeeService.minSalary(department);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee.toString();
    }

    @GetMapping(path = "/department/department-all")
    public String employeesOfTheDepartment(@RequestParam("department-all") Integer department) {
        List<Employee> listOfEmployee = null;

        try {
            listOfEmployee = employeeService.employeesOfTheDepartment(department);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee.toString();
    }

    @GetMapping(path = "/department/all")
    public String employeesWithDivisionOfDepartments() {
        List<Employee> listOfEmployee = null;

        try {
            listOfEmployee = employeeService.employeesWithDivisionOfDepartments();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee.toString();
    }
}
