package auto.grader.app;

import java.util.List;

public interface EmployeeRepository {
    Employee findById(String id);
    List<Employee> findAll();
    void save(Employee employee);
    void update(Employee employee);
    void delete(String id);
}

