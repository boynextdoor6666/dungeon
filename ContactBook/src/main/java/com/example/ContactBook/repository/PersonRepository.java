package com.example.ContactBook.repository;

import com.example.ContactBook.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT p FROM Person p WHERE p.firstName LIKE %:keyword% OR p.lastName LIKE %:keyword%")
    List<Person> searchByKeyword(@Param("keyword") String keyword);
}

