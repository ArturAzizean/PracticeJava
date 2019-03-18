package dbLessons;

import java.io.IOException;
import java.sql.*;

public class DbData {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        String username = "root";
        String password = "123";
        String connectionUrl = "jdbc:mysql://localhost:3306/jdbsTest";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(connectionUrl, username, password);
             Statement stat = conn.createStatement()) {

            stat.executeUpdate("drop table Books");
            stat.executeUpdate("create table if not exists Books (id mediumint not null auto_increment, name char(30) not null, dt DATE, primary key (id))");

//            PreparedStatement prepStat = conn.prepareStatement("insert into Books (name, dt) values ('someName',?)");
//            prepStat.setDate(1, new Date(1486512000021L));
//            prepStat.execute();

            stat.executeUpdate("insert into Books (name, dt) values ('someName', '2019-03-06')");
            ResultSet resultSet = stat.executeQuery("select * from Books");

            while (resultSet.next()) {
                System.out.println(resultSet.getDate("dt"));
            }
        }
    }
}
