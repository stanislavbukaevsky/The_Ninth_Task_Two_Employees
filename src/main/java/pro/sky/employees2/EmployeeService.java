package pro.sky.employees2;

import java.util.List;

public interface EmployeeService {

    List<Employee> listOfEmployees();

    Employee addEmployee(String firstName, String lastName, Integer department, Integer salary) throws EmployeeAlreadyAddedException;

    Employee deleteEmployee(String firstName, String lastName, Integer department, Integer salary) throws EmployeeNotFoundException;

    Employee toFindEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    List<Employee> withdrawalOfEmployees();

    Employee maxSalary(Integer department) throws EmployeeNotFoundException;

    Employee minSalary(Integer department) throws EmployeeNotFoundException;

    List<Employee> employeesOfTheDepartment(Integer department);

    List<Employee> employeesWithDivisionOfDepartments();
}
