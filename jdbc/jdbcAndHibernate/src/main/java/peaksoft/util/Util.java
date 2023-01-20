package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String username = "postgres";
    private final static String pssword = "postgres";

    public static Connection getConnection(){
        try {
           return DriverManager.getConnection(url,username,pssword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
