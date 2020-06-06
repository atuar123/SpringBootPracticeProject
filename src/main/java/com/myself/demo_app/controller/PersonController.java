package com.myself.demo_app.controller;

import com.myself.demo_app.entity.Person;
import com.myself.demo_app.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PersonController {
    private final PersonService personService;
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/")
    public String createPerson(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("personList", personService.getAll());
        return "addperson";
    }

    @PostMapping(value = "/savePerson")
    public String saveProduct(@Valid @ModelAttribute Person person, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "addperson";
        }
        personService.save(person);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePerson(@PathVariable("id") Long id) {
        personService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePerson(@PathVariable("id") Long id, Model model) {
        Person person = personService.get(id);
        model.addAttribute("person", person);
        model.addAttribute("personList", personService.getAll());
        return "addperson";
    }
}
