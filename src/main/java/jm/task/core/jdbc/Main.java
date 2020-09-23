package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService qwe = new UserServiceImpl();

        qwe.createUsersTable();

        qwe.saveUser("Ivan", "Ivanov", (byte) 32);
        qwe.saveUser("Petr", "Petrov", (byte) 23);
        qwe.saveUser("Sidr", "Sidorov", (byte) 16);

        qwe.removeUserById(2);

        qwe.getAllUsers().forEach(q -> System.out.println(q.toString()));

        qwe.cleanUsersTable();

        qwe.dropUsersTable();
    }
}
