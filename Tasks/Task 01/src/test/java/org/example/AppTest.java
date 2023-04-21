package org.example;


import config.AppConfig;
import modules.FirstLine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringRunner.class)
public class AppTest 
{
     @Autowired
     private ApplicationContext context;

     @Test
     public void testFirstLine() {
          System.out.println(context.getBean(FirstLine.class));
          assertTrue("firstLine бин не был создан", context.containsBean("firstLine"));
     }

     @Test
     public void testSecondLine() {
          assertTrue("secondLine бин не был создан", context.containsBean("secondLine"));
     }

     @Test
     public void testThirdLine() {
          assertTrue("thirdLine бин не был создан", context.containsBean("thirdLine"));
     }

     @Test
     public void testFourthLine() {
          assertTrue("fourthLine бин не был создан", context.containsBean("fourthLine"));
     }
}
