package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.JULY;
import static java.util.Calendar.OCTOBER;

@Configuration // configuration file
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student lupe = new Student(
                    "Lupe",
                    "lupe@her@gmail.io",
                    LocalDate.of(2000, OCTOBER, 18),
                    18
            );
            Student ronin = new Student(
                    "Ronin",
                    "ronin@he@gmail.io",
                    LocalDate.of(2008, JULY, 21),
                    32
            );

            //How to save student to the database
            repository.saveAll(
                    List.of(lupe, ronin)
            );
        };
    }
}
