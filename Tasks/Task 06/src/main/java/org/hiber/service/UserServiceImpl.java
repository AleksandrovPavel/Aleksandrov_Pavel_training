package org.hiber.service;

import org.hiber.dao.UserDao;
import org.hiber.model.Car;
import org.hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addCarToUser(Long userId, Car car) {
        userDao.addCarToUser(userId, car);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void removeCarFromUser(Long userId, Long carId) {
        userDao.removeCarFromUser(userId, carId);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public List<Car> getCarsByUserId(Long userId) {
        return userDao.getCarsByUserId(userId);
    }

    public Car getCarById(Long id) {
        return userDao.getCarById(id);
    }
}
