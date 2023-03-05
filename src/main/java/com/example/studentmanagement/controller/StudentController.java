package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody String studentData)
    {
        Student student=setStudent(studentData);
        int id=studentService.createStudent(student);
        return new ResponseEntity<>("Student added with id= "+id, HttpStatus.CREATED);

    }

    @GetMapping("find-by-first-name")
    public List<Student> getStudentByFirstName(@RequestParam String firstName){
        return studentService.getStudentByFirstName(firstName);
    }

    @GetMapping("find-by-first-and-last-name")
    public Student getStudentByFirstAndLastName(@RequestParam String firstName,@RequestParam String lastName){
        return studentService.getStudentByFirstAndLastName(firstName,lastName);
    }

    @GetMapping("find-by-age")
    public List<Student> getStudentByAge(@RequestParam Integer age){
        return studentService.getStudentByAge(age);
    }

    @GetMapping("find-by-active")
    public List<Student> getStudentActive(@RequestParam Boolean active)
    {
        return studentService.getStudentByActive(active);
    }

    @GetMapping("find-age-greater-than")
    public List<Student> findByAgeGreaterThan(@RequestParam Integer age){
        return studentService.getStudentByAgeGreaterThan(age);
    }

    @GetMapping("find-age-less-than")
    public List<Student> findByAgelessThan(@RequestParam Integer age){
        return studentService.getStudentByAgeLessThan(age);
    }

    @GetMapping("find-by-admission-date")
    public List<Student> findByAdmissionDate(@RequestParam Date date){
        return studentService.getStudentByAdmissionDate(date);
    }


    private Student setStudent(String studentData) {
        Student student=new Student();
        JSONObject jsonObject=new JSONObject(studentData);
        student.setFirstName(jsonObject.getString("firstName"));
        student.setLastName(jsonObject.getString("lastName"));
        student.setActive(jsonObject.getBoolean("active"));
        student.setAge(jsonObject.getInt("age"));
        student.setAdmissionDate(new Date());

        return student;
    }
}
