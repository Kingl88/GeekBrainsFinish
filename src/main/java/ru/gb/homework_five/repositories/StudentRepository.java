package ru.gb.homework_five.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.homework_five.entyties.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}