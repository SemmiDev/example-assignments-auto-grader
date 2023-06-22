package auto.grader.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeHashMapRepository implements EmployeeRepository {
    private Map<String, Employee> employees;

    public EmployeeHashMapRepository() {
        employees = new HashMap<>();
    }

    @Override
    public Employee findById(String id) {
        return employees.get(id);
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public void save(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    @Override
    public void update(Employee employee) {
        if (employees.containsKey(employee.getId())) {
            employees.put(employee.getId(), employee);
        }
    }

    @Override
    public void delete(String id) {
        employees.remove(id);
    }
}
