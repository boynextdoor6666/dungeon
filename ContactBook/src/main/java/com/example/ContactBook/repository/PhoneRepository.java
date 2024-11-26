package com.example.ContactBook.repository;

import com.example.ContactBook.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}

