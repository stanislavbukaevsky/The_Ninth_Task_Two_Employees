package pro.sky.employees2;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(Object err_empl_not_found) {
    }
}
