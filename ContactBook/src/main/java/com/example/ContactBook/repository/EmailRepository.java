package com.example.ContactBook.repository;
import com.example.ContactBook.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}

