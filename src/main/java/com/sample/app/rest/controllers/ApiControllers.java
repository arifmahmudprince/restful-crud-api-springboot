package com.sample.app.rest.controllers;

import com.sample.app.rest.model.Student;
import com.sample.app.rest.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping(value = "/health")
    public String getPage(){
        return "Welcome";
    }
    @GetMapping(value = "/students")
    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }

    @GetMapping(value = "/student/{id}")
    public Student getStudent(@PathVariable long id){
        return studentRepo.findById(id).get();
    }

    @PostMapping(value = "/student/create")
    public String saveStudent(@RequestBody Student student){
        System.out.println(student.toString());
        studentRepo.save(student);
        return "new student is saved successfully";
    }

    @PutMapping(value = "/student/update/{id}")
    public String updateStudent(@PathVariable long id, @RequestBody Student student){
        Student updateStudent = studentRepo.findById(id).get();
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setAddress(student.getAddress());
        updateStudent.setDepartment(student.getDepartment());
        updateStudent.setAge(student.getAge());
        studentRepo.save(updateStudent);

        return "student info has been updated successfully";
    }

    @DeleteMapping(value = "/student/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        studentRepo.delete(studentRepo.findById(id).get());
        return "student info has been deleted successfully";
    }
}
