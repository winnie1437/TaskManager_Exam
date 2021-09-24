package org.itstep.consumer;

import org.itstep.consumer.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder){
//        return builder.build();
//    }
//
//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
//        return args -> {
//          User user = restTemplate.getForObject(
//                  "http://localhost:8080/users/1", User.class
//          );
//        };
//    }
}
