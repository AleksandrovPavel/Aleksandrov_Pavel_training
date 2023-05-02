package jdbc;

import jdbc.dao.UserDaoHibernateImpl;
import jdbc.service.UserService;
import jdbc.service.UserServiceImpl;
import jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {

        UserDaoHibernateImpl userConnect = new UserDaoHibernateImpl();
        UserService userService = new UserServiceImpl(userConnect);
        userService.saveUser("Антоша", "Мантоша", (byte) 75);
        userService.dropUsersTable();
        userService.dropUsersTable();
        userService.createUsersTable();


    }
}
