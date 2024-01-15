package com.example.emailverification.service;


import com.example.emailverification.dto.PersonDto;
import com.example.emailverification.entity.Person;
import com.example.emailverification.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final EmailServiceImpl emailService;

    public PersonService(PersonRepository personRepository,EmailServiceImpl emailService) {
        this.personRepository = personRepository;
        this.emailService = emailService;
    }

    public boolean registerUser(PersonDto personDto){

        var uuid = UUID.randomUUID().toString();

        if(personRepository.findPersonByEmailId(personDto.email()).isEmpty()) {

            emailService.sendEmail(personDto.email(), uuid);

            personRepository.save(new Person(personDto.email(), personDto.password(), false, uuid));

            return true;
        }

        return false;

    }


    public String verify(String uuid){

        Optional<Person> personByUuid = personRepository.findPersonByUuid(uuid);

        if(personByUuid.isPresent()){
            Person person = personByUuid.get();

            if(!person.isEnabled()) {
                person.setEnabled(true);

                personRepository.save(person);
                return "verified";
            }
            else
                return "Email is already verified";
        }
        return "Invalid URL";
    }

}
