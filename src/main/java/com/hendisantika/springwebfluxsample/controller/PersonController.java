package com.hendisantika.springwebfluxsample.controller;

import com.hendisantika.springwebfluxsample.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-webflux-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/06/18
 * Time: 07.01
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/{id}")
    public Rendering findById(@PathVariable String id) {
        return Rendering.view("person")
                .modelAttribute("person", this.personRepository.findById(id))
                .build();
    }
}