package com.Backend.LibraryManagementSystem.Service;

import com.Backend.LibraryManagementSystem.Models.Book;
import com.Backend.LibraryManagementSystem.Models.LibraryCard;
import com.Backend.LibraryManagementSystem.Models.Transaction;
import com.Backend.LibraryManagementSystem.Repository.BookRepository;
import com.Backend.LibraryManagementSystem.Repository.CardRepository;
import com.Backend.LibraryManagementSystem.Repository.TransactionRepository;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public String issueBook(int bookId,int cardId) throws Exception {

        //1. Get Book Entity from bookId
        Book book = bookRepository.findById(bookId).get();

        //2. Get CardEntity from cardId
        LibraryCard card = cardRepository.findById(cardId).get();

        //3. Create the txn Entity
        Transaction transaction = new Transaction();

        // FAILURE : if the book is issued
        if(book.getIsIssued()) {
            throw new Exception("Book is already issued");
        }

        //FAILURE : noOfBooksIssued in card has reached the Limit
        if(card.getNoOfBooksIssued()==3){
            throw new Exception("Card Book issue Limit is reached");
        }

        //SUCCESS
        transaction.setTransactionStatus(TransactionStatus.ACTIVE);
        //Set Foreign Key entities (Book and Card)
        transaction.setBook(book);
        transaction.setCard(card);

        //set book to isIssued : True
        book.setIsIssued(true);

        //Set card : noOfBooksIssued + 1
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        transaction = transactionRepository.save(transaction);
        bookRepository.save(book);
        cardRepository.save(card);

        return "The transaction is saved with transactionId : "+transaction.getTransactionId();
    }

}
