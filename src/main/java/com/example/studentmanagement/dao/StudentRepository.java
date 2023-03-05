package com.example.studentmanagement.dao;

import com.example.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query(value = "select * from tbl_student where first_name= :firstName",nativeQuery = true)
    List<Student> findByFirstName(@Param("firstName") String firstName);

    @Query(value ="select * from tbl_student where first_name= :firstName and last_name= :lastName",nativeQuery = true)
    Student findByFirstNameAndLastName(@Param("firstName") String firstName,@Param("lastName") String lastName);

    @Query(value = "SELECT * FROM student WHERE age = :age", nativeQuery = true)
    List<Student> findByAge(@Param("age") Integer age);

    @Query(value = "SELECT * FROM student WHERE age > :age", nativeQuery = true)
    List<Student> findByAgeGreaterThan(@Param("age") Integer age);

    @Query(value = "SELECT * FROM student WHERE age < :age", nativeQuery = true)
    List<Student> findByAgeLessThan(@Param("age") Integer age);


    @Query(value = "SELECT * FROM student WHERE active = :active", nativeQuery = true)
    List<Student> findByActive(@Param("active") Boolean active);

    @Query(value = "SELECT * FROM student WHERE admission_date = :admissionDate", nativeQuery = true)
    List<Student> findByAdmissionDate(@Param("admissionDate") Date admissionDate);



}
