package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Connection getConnectJDBC() {
        String userName = "root";
        String password = "12345678";
        String connectionUrl = "jdbc:mysql://localhost:3306/schema_name?useSSL=false";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl, userName, password);
            System.out.println("We're connected!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    //private static SessionFactory factory;

    public static SessionFactory createSessionFactory() {
        SessionFactory factory = null;
        if (factory == null) {
            try {
                Properties prop = new Properties();
                prop.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
                prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                prop.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/schema_name?useSSL=false");
                prop.setProperty("hibernate.connection.username","root");
                prop.setProperty("hibernate.connection.password", "12345678");
                prop.setProperty("show_sql", "true");
                prop.setProperty("hibernate.hbm2ddl.auto", "create");
                prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");
                prop.setProperty("hibernate.hbm2ddl.auto", "update");
                factory = new Configuration()
                        .addProperties(prop)
                        .addAnnotatedClass(User.class)
                        .buildSessionFactory();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }

        return factory;
    }
}
