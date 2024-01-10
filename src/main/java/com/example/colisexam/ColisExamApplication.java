package com.example.colisexam;

import com.example.colisexam.entity.Colis;
import com.example.colisexam.repository.ColisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ColisExamApplication {


    public static void main(String[] args) {
        SpringApplication.run(ColisExamApplication.class, args);
    }


    @Bean
    CommandLineRunner coucou(){
      return  args->{
          System.out.println("gooood");
        };
    }
}
