package com.Backend.LibraryManagementSystem.Repository;

import com.Backend.LibraryManagementSystem.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
