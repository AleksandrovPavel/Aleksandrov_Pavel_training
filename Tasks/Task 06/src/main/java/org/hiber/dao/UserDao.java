package org.hiber.dao;


import org.hiber.model.Car;
import org.hiber.model.User;

import java.util.List;

public interface UserDao {

    void addCarToUser(Long userId, Car car);

    void addUser(User user);

    void addCar (Car car);

    void removeCarFromUser(Long userId, Long carId);

    List<User> getAllUsers();

    List<Car> getAllCars();

    User getUserById(Long id);

    List<Car> getCarsByUserId(Long userId);

    Car getCarById(Long id);
}
