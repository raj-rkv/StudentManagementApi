package com.example.studentmanagement.service;

import com.example.studentmanagement.dao.StudentRepository;
import com.example.studentmanagement.model.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public int createStudent(Student studentData){
        Student student=studentRepository.save(studentData);
        return student.getId();
    }

    public List<Student> getStudentByFirstName(String firstName){
        return studentRepository.findByFirstName(firstName);
    }

    public List<Student> getStudentByAge(Integer age){
        return studentRepository.findByAge(age);
    }

    public List<Student> getStudentByAgeGreaterThan(Integer age){
        return studentRepository.findByAgeGreaterThan(age);
    }

    public List<Student> getStudentByAgeLessThan(Integer age){
        return studentRepository.findByAgeLessThan(age);
    }

    public List<Student> getStudentByActive(Boolean active){
        return studentRepository.findByActive(active);
    }

    public List<Student> getStudentByAdmissionDate(Date date){
        return studentRepository.findByAdmissionDate(date);
    }
    public Student getStudentByFirstAndLastName(String firstName,String lastName)
    {
        return studentRepository.findByFirstNameAndLastName(firstName,lastName);
    }
}
