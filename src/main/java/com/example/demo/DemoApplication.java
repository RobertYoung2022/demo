package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController //

@RequestMapping(path = "/home")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //
	@GetMapping //TODO <- GetMapping + the @RestController makes this class into an RESTful method to GET some data
	public String hello() {
		return "Hello World";
	}

//	@GetMapping
//	public List<String> helloList() {
//		return List.of("Hello", "World");
//	}

//    @GetMapping
//    public List<Student> studentList() {
//        return List.of(
//                new Student(
//                        1L,
//                        "Lupe",
//                        "lupe@her@gkail.io",
//                        LocalDate.of(2000, Month.OCTOBER, 18),
//                        18
//
//                )
//        );
//    }
}
