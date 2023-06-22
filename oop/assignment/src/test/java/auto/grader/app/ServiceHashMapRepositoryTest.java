package auto.grader.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceHashMapRepositoryTest {
    private EmployeeService service;

    @BeforeEach
    public void setup() {
        // Inisialisasi service dengan repository yang sesuai
        EmployeeRepository repository = new EmployeeHashMapRepository();
        service = new EmployeeService(repository);
    }

    @Test
    public void testSaveEmployee() {
        // Persiapan data
        Employee employee = new Employee("1", "John Doe", "IT");

        // Simpan karyawan
        service.save(employee);

        // Cek apakah karyawan berhasil disimpan
        assertEquals(employee, service.findById("1"));
    }

    @Test
    public void testUpdateEmployee() {
        // Persiapan data
        Employee employee = new Employee("1", "John Doe", "IT");
        service.save(employee);

        // Update karyawan
        employee.setName("Jane Doe");
        employee.setDepartment("Finance");
        service.update(employee);

        // Cek apakah karyawan berhasil diupdate
        Employee updatedEmployee = service.findById("1");
        assertEquals("Jane Doe", updatedEmployee.getName());
        assertEquals("Finance", updatedEmployee.getDepartment());
    }

    @Test
    public void testDeleteEmployee() {
        // Persiapan data
        Employee employee = new Employee("1", "John Doe", "IT");
        service.save(employee);

        // Hapus karyawan
        service.delete("1");

        // Cek apakah karyawan berhasil dihapus
        assertNull(service.findById("1"));
    }

    @Test
    public void testFindAllEmployees() {
        // Persiapan data
        Employee employee1 = new Employee("1", "John Doe", "IT");
        Employee employee2 = new Employee("2", "Jane Smith", "Finance");
        service.save(employee1);
        service.save(employee2);

        // Ambil semua karyawan
        List<Employee> employees = service.findAll();

        // Cek apakah jumlah karyawan sesuai
        assertEquals(2, employees.size());

        // Cek apakah data karyawan benar
        assertTrue(employees.contains(employee1));
        assertTrue(employees.contains(employee2));
    }
}
