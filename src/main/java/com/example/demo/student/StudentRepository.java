package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//TODO: THIS IS THE DATA ACCESS LAYER
@Repository // makes this the repo to use - USED FOR DATA ACCESS

                        //what repo to work with / id:type for that table
public interface StudentRepository extends JpaRepository<Student, Long> {
    // THIS IS WHERE WE WILL NOW INPUT STUDENTS

}
