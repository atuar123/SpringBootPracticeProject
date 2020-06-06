package com.myself.demo_app.service;

import com.myself.demo_app.entity.Person;

import java.util.List;

public interface PersonService {
    Person save(Person person);
    Person update(Person person);
    Person get(Long id);
    String delete(Long id);
    List<Person> getAll();
}
