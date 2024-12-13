package com.jpahibernate.example.student_management_db.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // getter setter
@Entity// this is model class or entity class which directly represent the database table
@Table (name = "student") // it will create table inside database
public class Student {



    @Id // it is a primary key and it cannot take duplicate values
   @Column(name = "student_id" ,nullable = false) // it will create column in database with name studentId
    private int studentId;

    @Column(name = "name",nullable = false) // ,nullable = false -> it is mandatory fields and cannot be null
    private String name;

    @Column(name = "grade" ,nullable = false)
    private String grade;

    @Column(name = "email",nullable = false,unique = true)//unique = true-> it will take unique value
    private String email;

    @Column(name = "dob",nullable = false)
    private String dob;

    @Column(name = "password",nullable = false)
    private String password;


}
