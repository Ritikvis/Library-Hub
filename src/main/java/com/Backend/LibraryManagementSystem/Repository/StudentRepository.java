package com.Backend.LibraryManagementSystem.Repository;

import com.Backend.LibraryManagementSystem.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
