package com.epsilon.studentmanager.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @GetMapping
    public List<Student> getStudents() throws Exception {
        Student s = new Student(1L, "Shoaib Shaikh", "shoaib.shaikh@gmail.com", LocalDate.of(1994, Month.DECEMBER, 13));
        return List.of(s);
    }

}
