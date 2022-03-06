package com.epsilon.studentmanager.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController (StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() throws Exception {
        try{
            List<Student> students = this.studentService.getStudents();
            if (students.equals(null)){
                throw new Exception("INTERNAL_SERVER_ERROR");
            }
            return ResponseEntity.ok().body(students);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student){
        this.studentService.addStudent(student);
    }

}
