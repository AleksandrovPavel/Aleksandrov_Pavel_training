package org.scope.config;

import org.scope.models.Cat;
import org.scope.models.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.scope")
public class AppConfig {

    @Bean
    public Cat catBean() {
        return new Cat();
    }

    @Bean
    public Dog catDog() {
        return new Dog();
    }
}
