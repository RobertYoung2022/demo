package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//TODO: THIS IS THE SERVICE LAYER -
// BRIDGE BETWEEN API AND DATA ACCESS LAYERS
// THE BUSINESS OR BETTER YET LOGIC

@Service // annotates this will be the service class
//TODO Service tag - ???

public class StudentService {

    private final StudentRepository studentRepository; // How to access Repo


    // LIST DATA LOGIC
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    //TODO: Need constructor to call the repo selected

    public List<Student> getStudents() {
        return studentRepository.findAll(); // this return will return all students saved in the db through this specific method


        /* return List.of( // this is a static list
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
        );*/ // CODE BEFORE CONNECTING TO DATABASE
    }

    // ADD LOGIC
    public void addNewStudent(Student student) {
        Optional<Student> studentEmailCheck = studentRepository.findStudentByEmail(student.getEmail());
        if(studentEmailCheck.isPresent()) { // IF STUDENT IS NOT PRESENT THROW EXCEPTION (BELOW)
            throw new IllegalStateException("email taken"); // basic email expression
        }

        studentRepository.save(student);
    }

    // DELETE LOGIC
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exist");
        }
            studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with id " +studentId + "does not exist"));

                if(name != null &&
                            name.length() > 0 &&
                !Objects.equals(student.getName(), name)) {
                    student.setName(name);
                }

                if(email != null &&
                            email.length() > 0 &&
                            !Objects.equals(student.getEmail(), email)) {
                    Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
                    if (studentOptional.isPresent()) {
                        throw new IllegalStateException("email taken");
                    }
                    student.setEmail(email);
                }
    }
}
