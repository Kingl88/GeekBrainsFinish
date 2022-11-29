package ru.gb.homework_five.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework_five.entyties.Student;
import ru.gb.homework_five.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public void addOneThousandStudent(@RequestBody Student student) {
        service.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping()
    public List<Student> findAll(){
        return service.findAll();
    }

    @PutMapping()
    public void update(@RequestBody Student student) {
        service.update(student);
    }
}
