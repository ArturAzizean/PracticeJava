package dbLessons;

import java.sql.*;

public class DataBaseTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String username = "root";
        String password = "123";
        String connectionUrl = "jdbc:mysql://localhost:3306/jdbsTest";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(connectionUrl, username, password);
             Statement statement = conn.createStatement()) {

            statement.executeUpdate("drop table Books");
            statement.executeUpdate("create table if not exists Books (id mediumint not null auto_increment, name char(30) not null, primary key (id))");
            statement.executeUpdate("insert into Books (name) values('Inferno')");
            statement.executeUpdate("insert into Books set name = 'Solomon'");
            ResultSet resultSet = statement.executeQuery("select * from Books");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println("--------------------------------------");
            }

            System.out.println("______________-");
            ResultSet resultSet1 = statement.executeQuery("select name from Books where id = 1");
            while (resultSet1.next()) {
                System.out.println(resultSet1.getString(1));
            }
        }
    }
}
