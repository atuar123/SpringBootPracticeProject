package com.myself.demo_app.service.impl;

import com.myself.demo_app.entity.Person;
import com.myself.demo_app.repository.PersonRepository;
import com.myself.demo_app.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("personService")
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person get(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent() && personOptional.get() != null){
            Person person = personOptional.get();
            return person;
        }
        return null;
    }

    @Override
    public String  delete(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent() && personOptional.get() != null){
            Person person = personOptional.get();
            personRepository.delete(person);
            return "deletedSuccessfully";
        }
        return "recordNotFound";
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
