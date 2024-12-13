package com.jpahibernate.example.student_management_db.controller;


import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {
    //controller -> service -> repository(this is the flow of application)


    @Autowired
    private StudentService studentService;

      @PostMapping("/save")
      public String saveStudent(@RequestBody Student student){
        String response;
          response = studentService.addStudent(student);
          return response;


      }

      @GetMapping("/findAll")
      public List<Student> findAllStudents(){
        List<Student>studentList  = studentService.getAllStudents();

        return studentList;


      }
       @GetMapping("/find/{studentId}")
      public Student findStudentById(@PathVariable int studentId){
       Student student  =studentService.getStudentById(studentId);

       return student;

      }
      @DeleteMapping("/delete/{studentId}")
      public String deleteStudentById(@PathVariable int studentId){
       String response  = studentService.deleteStudentById(studentId);
       return  response;


      }
      // put -> we update whole field(whole object)
    //patch -> we update specific fields

    @PutMapping("/update/{studentId}")
      public String updateStudentUsingPut(@PathVariable int studentId, @RequestBody Student student){
      String response   = studentService.updateStudentUsingPut( studentId , student);
      return response;

      }





    }

