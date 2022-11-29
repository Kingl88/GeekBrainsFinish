package ru.gb.homework_five.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.homework_five.entyties.Student;
import ru.gb.homework_five.repositories.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public Student findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Студент не найден"));
    }

    public void save(Student student) {
            repository.save(student);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public void update(Student student) {
        Student studentTemp = repository.findById(student.getId()).orElseThrow(() -> new RuntimeException("Студент не найден"));
        studentTemp.setMark(student.getMark());
        studentTemp.setName(student.getName());
        repository.save(studentTemp);
    }
}
