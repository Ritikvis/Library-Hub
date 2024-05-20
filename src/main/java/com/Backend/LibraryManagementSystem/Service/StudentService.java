package com.Backend.LibraryManagementSystem.Service;

import com.Backend.LibraryManagementSystem.Models.Student;
import com.Backend.LibraryManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    public String addStudent(Student student){


        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(student.getEmailId());
        mailMessage.setFrom("projectbackend45@gmail.com");
        mailMessage.setSubject("Welcome to Library Hub !!");

        String body = "Hi "+student.getName()+" !" +
                "Welcome to Library Hub,I would like to welcome all new and returning students to BUE Library and to wish you a happy and successful new academic year..";
        mailMessage.setText(body);

        javaMailSender.send(mailMessage);

        studentRepository.save(student);
        return "Student has been saved to the DB";
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

}
