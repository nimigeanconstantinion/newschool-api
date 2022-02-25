package com.example.newschool.repository;

import com.example.newschool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface StudentRepo extends JpaRepository<Student,Long> {

    @Query("select s from Student s where s.email=?1")
    Optional<Student> findStudentByEmail(String email);
}
