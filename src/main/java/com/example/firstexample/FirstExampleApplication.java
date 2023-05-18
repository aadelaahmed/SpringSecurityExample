package com.example.firstexample;

import com.example.firstexample.model.Employee;
import com.example.firstexample.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FirstExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstExampleApplication.class, args);
    }
    @Bean
    CommandLineRunner init(EmployeeRepository employeeRepository){
        return args -> {
            Employee e1 = new Employee();
            e1.setFirstName("Adel");
            e1.setLastName("Ahmed");
            e1.setPassword("{noop}adel123");
            e1.setAuthorities(List.of("ROLE_USER", "ROLE_ADMIN"));

            e1.setEnabled(true);
            e1.setId(333);
            Employee e2 = new Employee();
            e2.setFirstName("Moemen");
            e2.setLastName("Ahmed");
            e2.setPassword("{noop}moemen123");
            e2.setAuthorities(List.of("ROLE_USER", "ROLE_ADMIN"));
            e2.setEnabled(true);
            e2.setId(777);

            employeeRepository.save(e1);
            employeeRepository.save(e2);
        };
    }
}
