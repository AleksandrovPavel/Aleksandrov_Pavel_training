package org.example;

import config.AppConfig;
import modules.FirstLine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        FirstLine poem =
                applicationContext.getBean(FirstLine.class);
        System.out.println(poem.toString());
    }
}
