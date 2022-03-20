package ro.unitbv.catalog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unitbv.catalog.entity.Nota;
import ro.unitbv.catalog.entity.Student;
import ro.unitbv.catalog.repository.StudentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public Student fetchStudentById(Long id) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        return studentOpt.orElse(null);
    }

    public Iterable<Student> fetchAll() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }
}
