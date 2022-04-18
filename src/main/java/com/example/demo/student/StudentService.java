package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//TODO
// THIS IS THE SERVICE LAYER -
// BRIDGE BETWEEN API AND DATA ACCESS LAYERS
// THE BUSINESS OR BETTER YET LOGIC

@Service // annotates this will be the service class
//TODO Service tag - makes this class into a Javabean
public class StudentService {
    public List<Student> getStudents() {
        return List.of( // this is a static list
                new Student(
                        1L,
                        "Lupe",
                        "lupe@her@gmail.io",
                        LocalDate.of(2000, Month.OCTOBER, 18),
                        18
                ),
                new Student(
                        2L,
                        "Ronin",
                        "ronin@he@gmail.io",
                        LocalDate.of(2008, Month.JULY, 21),
                        32
                )
        );
    } //TODO:
}
