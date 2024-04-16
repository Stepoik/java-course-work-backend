package ru.mirea.dentalclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DentalClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(DentalClinicApplication.class, args);
    }

}
