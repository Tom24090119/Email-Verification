package com.example.emailverification.repository;

import com.example.emailverification.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    Optional<Person> findPersonByEmailId(String email);

    Optional<Person>findPersonByUuid(String uuid);

}
