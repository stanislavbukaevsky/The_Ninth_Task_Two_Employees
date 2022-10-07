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
    public Object listOfEmployees() {
        List<Employee> listOfEmployee = null;

        try {
            listOfEmployee = employeeService.listOfEmployees();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee;
    }

    @GetMapping(path = "/add")
    public Object addEmployee(@RequestParam("lastName") String lastName,
                              @RequestParam("firstName") String firstName,
                              @RequestParam("department") Integer department,
                              @RequestParam("salary") Integer salary) throws EmployeeAlreadyAddedException {
        Employee listOfEmployee = null;

        try {
            listOfEmployee = employeeService.addEmployee(lastName, firstName, department, salary);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee;
    }

    @GetMapping(path = "/delete")
    public Object deleteEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("department") Integer department,
                                 @RequestParam("salary") Integer salary) throws EmployeeNotFoundException {
        Employee listOfEmployee = null;

        try {
            listOfEmployee = employeeService.deleteEmployee(lastName, firstName, department, salary);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee;
    }

    @GetMapping(path = "/find")
    public Object toFindEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName) throws EmployeeNotFoundException {
        Employee listOfEmployee = null;

        try {
            listOfEmployee = employeeService.toFindEmployee(lastName, firstName);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee;
    }

    @GetMapping(path = "/with")
    public Object withdrawalOfEmployees() {
        List<Employee> listOfEmployees = null;

        try {
            listOfEmployees = employeeService.withdrawalOfEmployees();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployees;
    }

    @GetMapping(path = "/department/max-salary")
    public Object maxSalary(@RequestParam("department-max") Integer department) {
        Employee listOfEmployee = null;

        try {
            listOfEmployee = employeeService.maxSalary(department);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee;
    }

    @GetMapping(path = "/department/min-salary")
    public Object minSalary(@RequestParam("department-min") Integer department) {
        Employee listOfEmployee = null;

        try {
            listOfEmployee = employeeService.maxSalary(department);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee;
    }

    @GetMapping(path = "/department/department-all")
    public Object employeesOfTheDepartment(@RequestParam("department-all") Integer department) {
        List<Employee> listOfEmployee = null;

        try {
            listOfEmployee = employeeService.employeesOfTheDepartment(department);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee;
    }

    @GetMapping(path = "/department/all")
    public Object employeesWithDivisionOfDepartments() {
        List<Employee> listOfEmployee = null;

        try {
            listOfEmployee = employeeService.employeesWithDivisionOfDepartments();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return listOfEmployee;
    }
}
