package com.hendisantika.springwebfluxsample;

import com.hendisantika.springwebfluxsample.entity.Person;
import com.hendisantika.springwebfluxsample.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-webflux-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/06/18
 * Time: 06.58
 * To change this template use File | Settings | File Templates.
 */
@Component
public class InitDataBase implements CommandLineRunner {

    private final PersonRepository personRepository;

    public InitDataBase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) {
        List<Person> persons = Arrays.asList(
                new Person("uzumaki", "naruto"),
                new Person("sakura", "haruno"),
                new Person("hatake", "kakashi"),
                new Person("hyuuga", "hinata"),
                new Person("uchiha", "sasuke"));
        this.personRepository.deleteAll()
                .thenMany(this.personRepository.saveAll(persons))
                .subscribe(null, null,
                        () -> this.personRepository.findAll().subscribe(System.out::println));
    }
}