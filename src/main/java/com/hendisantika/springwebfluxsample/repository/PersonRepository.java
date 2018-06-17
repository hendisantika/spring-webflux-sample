package com.hendisantika.springwebfluxsample.repository;

import com.hendisantika.springwebfluxsample.entity.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-webflux-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/06/18
 * Time: 06.57
 * To change this template use File | Settings | File Templates.
 */
public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
}
