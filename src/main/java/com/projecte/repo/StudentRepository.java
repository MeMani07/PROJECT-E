package com.projecte.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecte.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
