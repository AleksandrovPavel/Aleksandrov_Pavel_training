package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String DB_HOST  = "192.168.0.50";
    private static String DB_USERNAME = "pva88";
    private static String DB_PASSWORD = "2001";
    private static String DB_NAME = "pva88_db";
    private static String DB_PORT = ":5432/";
    private static String URL = "jdbc:postgresql://"    //jdbc:postgresql://<host>:<port>/<database_name>?<connection_parameters>
            + DB_HOST
            + DB_PORT
            + DB_NAME;



    /**
     * Получить соединение с базой данных PostgreSQL с использованием заданных параметров подключения.
     * @param connectionURL URL для подключения к базе данных PostgreSQL
     * @param username имя пользователя базы данных PostgreSQL
     * @param password пароль пользователя базы данных PostgreSQL
     * @return соединение с базой данных PostgreSQL
     * @throws SQLException если не удалось установить соединение с базой данных
     */
    public static Connection getConnection(String connectionURL,
                                           String username,
                                           String password)
            throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection =  DriverManager.getConnection(connectionURL,
                username, password);
        return connection;
    }

    /**
     * Получить соединение с базой данных PostgreSQL с использованием параметров подключения,
     * заданных внутри класса.
     * @return соединение с базой данных PostgreSQL
     * @throws SQLException если не удалось установить соединение с базой данных
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return getConnection(URL, DB_USERNAME, DB_PASSWORD);
    }
}
