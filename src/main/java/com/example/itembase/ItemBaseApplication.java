package com.example.itembase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.itembase")
@EnableJpaRepositories("com.example.itembase")
public class ItemBaseApplication {


    public static void main(String[] args) {
        SpringApplication.run(ItemBaseApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ItemRepository repository) {
        return (args) -> {
            repository.save(new Item(1L, "Bracer", 50F, "Strength artifact"));
            repository.save(new Item(2L, "Clarity", 250F, "Best item"));
        };
    }


}
