package jdbc.dao;


import jdbc.model.User;
import jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {


    @Override
    public void createUsersTable() {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {


        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void dropUsersTable() {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            String sql = "DROP TABLE IF EXISTS test.users";

            session.beginTransaction();
            session.createNativeQuery(sql, User.class).executeUpdate();

            session.getTransaction().commit();

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);

            session.persist(user);
            session.getTransaction().commit();

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void removeUserById(long id) {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            User user = new User();
            user.setId(id);

            session.remove(user);
            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<User> getAllUsers() {

        List<User> users;

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Query<User> query = session.createQuery("from User", User.class);
            users = query.list();

            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public void cleanUsersTable() {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            String sql = "DELETE FROM test.users";

            session.beginTransaction();
            session.createNativeQuery(sql, User.class).executeUpdate();
            session.getTransaction().commit();

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
