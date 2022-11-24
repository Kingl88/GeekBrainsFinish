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

    public void save() {
        for (int i = 0; i < 1000; i++) {
            repository.save(new Student("Name" + i, i));
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public void update(Long id, String name, int mark) {
        Student student = repository.findById(id).orElseThrow(() -> new RuntimeException("Студент не найден"));
        student.setMark(mark);
        student.setName(name);
        repository.save(student);
    }
}
