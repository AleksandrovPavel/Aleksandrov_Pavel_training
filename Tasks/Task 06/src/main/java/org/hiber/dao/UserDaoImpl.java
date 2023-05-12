package org.hiber.dao;

import jakarta.transaction.Transactional;
import org.hiber.model.Car;
import org.hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {


    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addCarToUser(Long userId, Car car) {

        if (car != null) {
            Session session = sessionFactory.openSession();

            User user = session.get(User.class, userId);
            car.setOwner(user);

            user.getCars().add(car);

            session.save(car);

        }
    }

    public void addUser(User user) {

        if (user != null) {
            sessionFactory.openSession()
                    .save(user);
        }
    }

    public void addCar(Car car) {

        if (car != null) {
            sessionFactory.openSession()
                    .save(car);
        }
    }

    public void removeCarFromUser(Long userId, Long carId) {
        Session session = sessionFactory.openSession();
        Car car = session.get(Car.class, carId);
        session.get(User.class, userId).getCars().remove(car);


    }

    public List<User> getAllUsers() {
        return sessionFactory.openSession()
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    public List<Car> getAllCars() {
        return sessionFactory.openSession()
                .createQuery("SELECT c From Car c", Car.class)
                .getResultList();
    }

    public User getUserById(Long id) {
        return sessionFactory.openSession()
                .get(User.class, id);
    }

    public List<Car> getCarsByUserId(Long userId) {

        return sessionFactory.openSession()
                .get(User.class, userId)
                .getCars();
    }

    public Car getCarById(Long id) {
        return sessionFactory.openSession()
                .get(Car.class, id);
    }
}
