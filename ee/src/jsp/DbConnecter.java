package jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnecter {
    private String username = "root";
    private String password = "123";
    private String connectionUrl = "jdbc:mysql://localhost:3306/jdbsTest";
    Connection connection;

    public DbConnecter() {
        try {
            connection = DriverManager.getConnection(connectionUrl, username, password);
            Class.forName("com.mysql.jdbc.Driver");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
