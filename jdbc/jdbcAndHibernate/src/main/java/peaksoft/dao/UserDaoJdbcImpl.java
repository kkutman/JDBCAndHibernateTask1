package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    private Connection connection;
    public UserDaoJdbcImpl() {
        this.connection=Util.getConnection();
    }

    public void createUsersTable() {
        String query = """
                create table if not exists users(
                id serial primary key,
                name varchar(50) not null,
                last_name varchar(50) not null,
                age smallint not null ); """;
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {
        String query = """
                drop table users cascade """;
        try {
            Statement statement  = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String query = """
                insert into users (name,last_name,age)
                values(?,?,?);
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeUserById(long id) {
        String query = """
                delete from users where id = ?""";

        try( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1,id);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getAllUsers() {
        List<User>users = new ArrayList<>();
        String query = """
                select * from users;""";
        try {
            Statement preparedStatement = connection.createStatement();

            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                users.add(new User(resultSet.getLong("id"),resultSet.getString("name"),
                        resultSet.getString("name"), resultSet.getByte("age")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void cleanUsersTable() {
        String query = """
                truncate table users;""";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}