package com.example.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return arg->{
            Student harsh = new Student("Harsh", LocalDate.of(2000, Month.JANUARY,26) , "harshdhounchak4@gmail.com"
            );

            Student alex = new Student("Alex", LocalDate.of(2000, Month.JANUARY,26) , "Alex4@gmail.com"
            );

            repository.saveAll(
                    List.of(harsh , alex)
            );
        };

    }
}
