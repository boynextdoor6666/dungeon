package com.example.ContactBook.controller;

import com.example.ContactBook.model.Person;
import com.example.ContactBook.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public String listPersons(Model model) {
        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "persons";
    }

    @GetMapping("/persons/new")
    public String createPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "create_person";
    }

    @PostMapping("/persons")
    public String savePerson(@ModelAttribute("person") Person person) {
        personRepository.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/persons/edit/{id}")
    public String editPersonForm(@PathVariable Long id, Model model) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        model.addAttribute("person", person);
        return "edit_person";
    }

    @PostMapping("/persons/{id}")
    public String updatePerson(@PathVariable Long id, @ModelAttribute("person") Person person) {
        personRepository.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/persons/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return "redirect:/persons";
    }

    @GetMapping("/persons/search")
    public String searchPersons(@RequestParam String query, Model model) {
        List<Person> persons = personRepository.searchByKeyword(query);
        model.addAttribute("persons", persons);
        return "persons";
    }
}

