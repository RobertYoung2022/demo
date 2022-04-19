package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // annotates this will be the controller class


//TODO
// THIS IS THE API LAYER -
// { GET POST PUT DELETE }

@RequestMapping(path = "api/v1/student") // ex. (localhost:8080/api/v1/student)
public class StudentController {

    //
    private final StudentService pickStudentService;

    @Autowired //TODO what does this do exactly?
    public StudentController(StudentService pickStudentService) {
        this.pickStudentService = pickStudentService;
    }

    @GetMapping // GET request from Service class > getStudents method
    public List<Student> getStudents() {
        return pickStudentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        pickStudentService.addNewStudent(student);
    }
}
