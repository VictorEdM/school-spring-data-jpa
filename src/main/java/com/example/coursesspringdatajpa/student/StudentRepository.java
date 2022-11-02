package com.example.coursesspringdatajpa.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String firstName);


    @Query(
            value = "SELECT * FROM students AS s WHERE s.last_name = ?1",
            nativeQuery = true
    )
    List<Student> findByLastName(String lastName);

    List<Student> findStudentsByGuardianName(String name);

    @Query("select s from Student s where s.emailAddress = ?1")
    Student findStudentByEmailAddress(String emailAddress);

    @Query("select s.firstName from Student as s where s.emailAddress = ?1")
    String findStudentFirstNameByEmailAddress(String emailAddress);
}
