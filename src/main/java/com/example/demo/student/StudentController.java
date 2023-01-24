package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }



    private final StudentService studentService ;

    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId) ;
    }

    @PutMapping(path="{studentId}")
    public void UpdateStudent(@PathVariable("studentId") Long studentId ,
                              @RequestParam(required = false) String name ,
                              @RequestParam(required = false) String email){

        studentService.updateStudent(studentId , name , email) ;

    }


    @GetMapping("/get")
    public List<Student> getStudents(){
           return studentService.getStudents() ;
    }

    @PostMapping("/post")
    public void registerNewStudent(@RequestBody Student student){

        studentService.addNewStudent(student);
    }




}
