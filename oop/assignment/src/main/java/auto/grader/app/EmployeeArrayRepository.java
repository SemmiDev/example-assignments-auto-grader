package auto.grader.app;

import java.util.Arrays;
import java.util.List;

public class EmployeeArrayRepository implements EmployeeRepository {
    private Employee[] employees;
    private int size;

    public EmployeeArrayRepository(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    @Override
    public Employee findById(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId().equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return Arrays.asList(Arrays.copyOf(employees, size));
    }

    @Override
    public void save(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        }
    }

    @Override
    public void update(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId().equals(employee.getId())) {
                employees[i] = employee;
                break;
            }
        }
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId().equals(id)) {
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[--size] = null;
                break;
            }
        }
    }
}

