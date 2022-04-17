package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController //


@RequestMapping(path = "api/v1/student") // ex. (localhost:8080/api/v1/student)
public class StudentController {
    @GetMapping
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Lupe",
                        "lupe@her@gkail.io",
                        LocalDate.of(2000, Month.OCTOBER, 18),
                        18

                )
        );
    }
}
