package dbLessons;

import java.sql.*;

public class DbUser {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String username = "root";
        String password = "123";
        String connectionUrl = "jdbc:mysql://localhost:3306/jdbsTest";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(connectionUrl, username, password);
             Statement stat = conn.createStatement()) {

            stat.execute("drop table Users");
            stat.executeUpdate("create table if not exists Users (id mediumint not null auto_increment, name char(30) not null, password char(30) not null , primary key (id))");
            stat.executeUpdate("insert into Users (name, password) values ('art', '123')");
            stat.executeUpdate("insert into Users set name = 'OtherUser', password = '123'");

            String userId = "1";
//            ResultSet res = stat.executeQuery("select * from Users where id = '" + userId + "'");
//            while (res.next()) {
//                System.out.println("Username: " + res.getString("name"));
//                System.out.println("Password: " + res.getString("password"));


            PreparedStatement ps = conn.prepareStatement("select * from Users where id = ?");
            ps.setString(1, userId);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println("name: " + resultSet.getString("name"));
                System.out.println("name: " + resultSet.getString("password"));
            }
        }
    }
}