package org.scope;

import org.scope.config.AppConfig;
import org.scope.models.Cat;
import org.scope.models.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Cat firstCat = applicationContext.getBean("catBean", Cat.class);
        Cat secondCat = applicationContext.getBean("catBean", Cat.class);
        Dog firstDog = applicationContext.getBean("catDog", Dog.class);
        Dog secondDog = applicationContext.getBean("catDog", Dog.class);

        firstCat.setMessage("Дай покушать");
        System.out.println("Первый котик говорит: " + firstCat.getMessage());
        System.out.println("Второй котик говорит: " + secondCat.getMessage());
        if (!firstCat.getMessage().equals(secondCat.getMessage())) {
            System.err.println("Кушать хочет только один котик");
        }
        firstDog.setMessage("Дай поесть");
        System.out.println("Первый пёс говорит: " + firstDog.getMessage());
        System.out.println("Второй пёс говорит: " + secondDog.getMessage());
        if (!firstDog.getMessage().equals(secondDog.getMessage())) {
            System.err.println("Псы всегда голодны");
        }

    }
}
