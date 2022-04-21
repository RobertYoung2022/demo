package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        pickStudentService.deleteStudent(studentId); // .deleteStudent() <- needs to have method in service
    }


    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        pickStudentService.updateStudent(studentId, name, email);
    }

}
