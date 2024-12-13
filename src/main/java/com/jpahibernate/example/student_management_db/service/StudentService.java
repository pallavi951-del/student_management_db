package com.jpahibernate.example.student_management_db.service;


import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // it will contain the business logic of the application
public class StudentService {

    @Autowired // it will  create internal Bean - object of spring IOC container
    private StudentRepository studentRepository;


    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Student saved into database successfully";


    }

    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;

    }

    public Student getStudentById(int studentId) {

        Optional<Student> studentOptional = studentRepository.findById(studentId);
        return studentOptional.get();
    }

    public String deleteStudentById(int studentId) {
        studentRepository.deleteById(studentId);
        return "Student with id " + studentId + " got delete";
    }


    public String updateStudentUsingPut(int studentId, Student newStudentRequest) {
        // find the student with id
        // if student present update it
        // else cannot update
        Student student = getStudentById(studentId);
        if (student != null) {
            studentRepository.save(newStudentRequest);
            return " student updated";
        } else {
            return "Student not found cannot updated";
        }

    }




    }

