package auto.grader.app;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListRepository implements EmployeeRepository {
    private List<Employee> employees;

    public EmployeeListRepository() {
        employees = new ArrayList<>();
    }

    @Override
    public Employee findById(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void update(Employee employee) {
        Employee existingEmployee = findById(employee.getId());
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setDepartment(employee.getDepartment());
        }
    }

    @Override
    public void delete(String id) {
        Employee employee = findById(id);
        if (employee != null) {
            employees.remove(employee);
        }
    }
}
