package com.Backend.LibraryManagementSystem.Repository;

import com.Backend.LibraryManagementSystem.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
