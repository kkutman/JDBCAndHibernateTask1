package peaksoft.service;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();

    public String createUsersTable() {
        userDaoJdbc.createUsersTable();
        return "TABLE SAVE SUCCESSFULLY";
    }

    public void dropUsersTable() {
        userDaoJdbc.dropUsersTable();
        System.out.println("TABLE DELETED SUCCESSFULLY");

    }

    public String saveUser(String name, String lastName, byte age) {
        userDaoJdbc.saveUser(name,lastName,age);
        return "USERS SAVE SUCCESSFULLY";
    }

    public void removeUserById(long id) {
        userDaoJdbc.removeUserById(id);
        System.out.println("USER DELETED SUCCESSFULLY");

    }

    public List<User> getAllUsers() {
        return userDaoJdbc.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJdbc.cleanUsersTable();
        System.out.println("TABLE SUCCESSFULLY CLEARED");
    }
}
