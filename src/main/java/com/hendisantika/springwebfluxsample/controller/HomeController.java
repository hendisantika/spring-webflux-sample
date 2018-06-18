package com.hendisantika.springwebfluxsample.controller;

import com.hendisantika.springwebfluxsample.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-webflux-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/06/18
 * Time: 07.00
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {

    private final PersonRepository personRepository;

    public HomeController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public Rendering findAll() {
        return Rendering.view("index")
                .modelAttribute("persons", this.personRepository.findAll())
                .build();
    }

}