package org.hiber;

import org.hiber.config.AppConfig;
import org.hiber.dao.UserDao;
import org.hiber.dao.UserDaoImpl;
import org.hiber.model.Car;
import org.hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SessionFactory sessionFactory = applicationContext.getBean("sessionFactory", SessionFactoryImpl.class);

        UserDao userDao = new UserDaoImpl(sessionFactory);


        User user1 = new User();
        user1.setLastName("Pavel");
        user1.setFirstName("Aleksandrov");
        user1.setEmail("pvaleksandrov@gmail.com");

        User user2 = new User();
        user2.setLastName("Дмитрий");
        user2.setFirstName("Мухов");
        user2.setEmail("muxov@gmail.com");

        User user3 = new User();
        user3.setLastName("Марина");
        user3.setFirstName("Кракова");
        user3.setEmail("cracova@gamil.com");

        userDao.addUser(user1);
        userDao.addUser(user2);
        userDao.addUser(user3);

        Car car1 = new Car();
        car1.setModel("Жигули 7");

        Car car2 = new Car();
        car2.setModel("BMW");

        Car car3 = new Car();
        car3.setModel("AUDI");

        userDao.addCarToUser(1L, car1);
        userDao.addCar(car2);
        userDao.addCar(car3);


        System.out.println(userDao.getAllUsers());
        System.out.println(userDao.getAllCars());
        System.out.println(userDao.getUserById(1L));
        System.out.println(userDao.getCarById(1L));
        System.out.println(userDao.getCarsByUserId(1L));

        userDao.removeCarFromUser(1L, 1L);

        System.out.println(userDao.getCarsByUserId(1L));
    }
}
