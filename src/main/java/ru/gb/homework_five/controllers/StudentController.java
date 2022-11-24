package ru.gb.homework_five.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework_five.entyties.Student;
import ru.gb.homework_five.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("{id}")
    public Student findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("add1000Student")
    public void addOneThousandStudent() {
        service.save();
    }

    @GetMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/allStudent")
    public List<Student> findAll(){
        return service.findAll();
    }

    @GetMapping("update")
    public void update(@RequestParam Long id, @RequestParam String name, @RequestParam int mark) {
        service.update(id, name, mark);
    }
}
