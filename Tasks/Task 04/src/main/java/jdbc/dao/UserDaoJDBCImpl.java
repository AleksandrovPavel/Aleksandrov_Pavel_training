package jdbc.dao;

import jdbc.model.User;
import jdbc.util.Util;
import org.w3c.dom.ranges.RangeException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    //language=SQL
    public static final String SQL_INSERT =
            "insert into test.users(name, lastname, age) " +
                    "values(?,?,?) ";

    //language=SQL
    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE test.users (id serial primary key, name text, lastName text, age int)";

    //language=SQL
    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF exists test.users";

    //language=SQL
    public static final String SQL_REMOVE_USER_BY_ID =
            "DELETE FROM test.users WHERE id = ?";

    //language=SQL
    public static final String SQL_CLEAN_USERS_TABLE =
            "DELETE FROM test.users";

    //language=SQL
    public static final String SQL_GET_ALL_USERS =
            "SELECT * FROM test.users";

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_TABLE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DROP_TABLE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*В тесте всегда значение один
     * в реальной базе значения всегда передаются разные,
     * ведь удалить мы хотим определенного персонажа*/
    public void removeUserById(long id) {
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_REMOVE_USER_BY_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        try (Connection connection = Util.getConnection();
             ResultSet resultSet = connection.createStatement().executeQuery(SQL_GET_ALL_USERS)) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CLEAN_USERS_TABLE)) {

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
