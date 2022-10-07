package pro.sky.employees2;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Object ERR_EMPL_NOT_FOUND = "Сотрудник с таким именем не существует";
    private final List<Employee> employeesList;

    public EmployeeServiceImpl(List<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    @Override
    public List<Employee> listOfEmployees() {
        employeesList.add(new Employee("Соколов", "Артем", 1, 20500));
        employeesList.add(new Employee("Панкратова", "Ангелина", 2, 22500));
        employeesList.add(new Employee("Орлов", "Дмитрий", 3, 24500));
        employeesList.add(new Employee("Кузнецова", "Софья", 4, 26500));
        employeesList.add(new Employee("Соловьев", "Вячеслав", 5, 28500));
        employeesList.add(new Employee("Иванова", "Ярослава", 2, 30500));
        employeesList.add(new Employee("Зиновьев", "Никита", 4, 32500));
        employeesList.add(new Employee("Маслова", "Софья", 1, 34500));
        employeesList.add(new Employee("Трофимов", "Роман", 3, 36500));
        employeesList.add(new Employee("Яковлева", "Мария", 5, 38500));
        return employeesList;
    }


    @Override
    public Employee addEmployee(String firstName, String lastName, Integer department, Integer salary) throws EmployeeAlreadyAddedException {
        Employee listOfEmployee = new Employee(firstName, lastName, department, salary);

        if (employeesList.contains(listOfEmployee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeesList.add(listOfEmployee);
        return listOfEmployee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName, Integer department, Integer salary) throws EmployeeNotFoundException {
        Employee listOfEmployee = new Employee(firstName, lastName, department, salary);

        if (employeesList.contains(listOfEmployee)) {
            employeesList.remove(listOfEmployee);
            return listOfEmployee;
        }
        throw new EmployeeNotFoundException(ERR_EMPL_NOT_FOUND);
    }

    @Override
    public Employee toFindEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        final Optional<Employee> listOfEmployee = employeesList.stream()
                .filter(employee -> employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName))
                .findAny();
        return listOfEmployee.orElseThrow(() -> new EmployeeNotFoundException(ERR_EMPL_NOT_FOUND));
    }

    @Override
    public List<Employee> withdrawalOfEmployees() {
        return Collections.unmodifiableList(employeesList);
    }

    @Override
    public Employee maxSalary(Integer department) throws EmployeeNotFoundException {
        return employeesList.stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException(ERR_EMPL_NOT_FOUND));
    }

    @Override
    public Employee minSalary(Integer department) throws EmployeeNotFoundException {
        return employeesList.stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException(ERR_EMPL_NOT_FOUND));
    }

    @Override
    public List<Employee> employeesOfTheDepartment(Integer department) {
        return employeesList.stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> employeesWithDivisionOfDepartments() {
        return Collections.unmodifiableList(employeesList.stream()
                .sorted(Comparator.comparingInt(employee -> employee.getDepartment()))
                .collect(Collectors.toList()));
    }
}
