package auto.grader.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    public WebResponse<Student> create(@RequestBody Student student) {
        Student createdStudent = studentRepository.save(student);
        return WebResponse.<Student>builder()
                .data(createdStudent)
                .build();
    }

    @GetMapping
    public WebResponse<List<Student>> findAll() {
        return WebResponse.<List<Student>>builder()
                .data(studentRepository.findAll())
                .build();
    }

    @GetMapping("/{id}")
    public WebResponse<Student> findById(@PathVariable String id) {
        if (studentRepository.findById(id).isPresent()) {
            return WebResponse.<Student>builder()
                    .data(studentRepository.findById(id).get())
                    .build();
        } else {
            return WebResponse.<Student>builder()
                    .errors("NOT FOUND")
                    .build();
        }
    }

    @GetMapping("/count")
    public WebResponse<Integer> count() {
        return WebResponse.<Integer>builder()
                .data(studentRepository.findAll().size())
                .build();
    }
}
