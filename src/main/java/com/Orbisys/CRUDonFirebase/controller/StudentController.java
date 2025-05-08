package com.Orbisys.CRUDonFirebase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Orbisys.CRUDonFirebase.model.Student;
import com.Orbisys.CRUDonFirebase.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){

       return (studentService.saveStudent(student)) ? "Success" : "Issue";
  
    }

    @GetMapping("/read/{id}")
    public Student getStudent(@PathVariable("id") int id){
        return studentService.getStudent(id);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        return studentService.deleteStudent(id) ? "Deleted" : "Issue";
    }
}
