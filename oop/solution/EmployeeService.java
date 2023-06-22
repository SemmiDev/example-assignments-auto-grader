package auto.grader.app;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findById(String id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    public void delete(String id) {
        employeeRepository.delete(id);
    }
}
