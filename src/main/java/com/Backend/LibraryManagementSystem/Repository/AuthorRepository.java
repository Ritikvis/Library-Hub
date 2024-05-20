package com.Backend.LibraryManagementSystem.Repository;

import com.Backend.LibraryManagementSystem.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
