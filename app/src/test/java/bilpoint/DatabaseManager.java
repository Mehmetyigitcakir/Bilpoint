package bilpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static DatabaseManager instance;
    private Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/bilpoint_db";
    private final String USER = "root";
    private final String PASS = "";

    private DatabaseManager() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection is successful");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not connected to database");
        }
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}