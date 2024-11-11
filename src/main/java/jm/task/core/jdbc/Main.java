package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;

public class Main {
//    private static final UserService userService = new UserServiceImpl();
//    private static final User user1 = new User("Mitroy", "Gopit", (byte) 60);
//    private static final User user2 = new User("Jija", "Top", (byte) 15);
//    private static final User user3 = new User("Stariy", "Pes", (byte) 126);
//    private static final User user4 = new User("Legkiy", "Qyqer", (byte) 76);

    public static void main(String[] args) {

        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();
        userDao.saveUser("alex", "petrov", (byte) 20);
        userDao.saveUser("tony", "sidorov", (byte) 22);
        userDao.saveUser("ivan", "ivaniv", (byte) 23);
        userDao.saveUser("sasha", "tanya", (byte) 34);
        userDao.getAllUsers();

        userDao.createUsersTable();
        userDao.getAllUsers();

        userDao.cleanUsersTable();

        userDao.dropUsersTable();

//        userService.createUsersTable();
//
//        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
//
//        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
//
//        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
//
//        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
//
//        userService.getAllUsers();

        //userService.cleanUsersTable();

      // userService.dropUsersTable();
    }
}
