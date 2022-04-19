package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//TODO: THIS IS THE DATA ACCESS LAYER
@Repository // makes this the repo to use - USED FOR DATA ACCESS

                        //what repo to work with / id:type for that table
public interface StudentRepository extends JpaRepository<Student, Long> {
    // THIS IS WHERE WE WILL NOW INPUT STUDENTS

    // FIND A USER BY EMAIL
    @Query("SELECT s FROM Student s WHERE s.email = ?1")


    // SELECT * FROM student WHERE email = ?
    Optional<Student> findStudentByEmail(String email);
}
