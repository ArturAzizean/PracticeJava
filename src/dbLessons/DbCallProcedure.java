package dbLessons;

import java.io.IOException;
import java.sql.*;

public class DbCallProcedure {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        String username = "root";
        String password = "123";
        String connectionUrl = "jdbc:mysql://localhost:3306/jdbsTest";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(connectionUrl, username, password);
             Statement stat = conn.createStatement()) {

            stat.executeUpdate("drop table Books");
            stat.executeUpdate("create table if not exists Books (id mediumint not null auto_increment, name char(30) not null, dt DATE, primary key (id))");
            stat.executeUpdate("insert into Books (name) values('Inferno')");
            stat.executeUpdate("insert into Books set name = 'Solomon'");

            CallableStatement callableStatement = conn.prepareCall("{call BooksCount(?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));
            System.out.println("_______________________________");

            CallableStatement callableStatement1 = conn.prepareCall("{call getBooks(?)}");
            callableStatement1.setInt(1, 1);
            if (callableStatement1.execute()) {
                ResultSet resultSet = callableStatement1.getResultSet();
                while (resultSet.next()) {
                    System.out.println("id: " + resultSet.getInt("id"));
                    System.out.println("name: " + resultSet.getString("name"));
                }
            }

            CallableStatement callableStatement2 = conn.prepareCall("{call getCount()}");
            boolean hasResults = callableStatement2.execute();
            while (hasResults) {
                ResultSet resultSet2 = callableStatement2.getResultSet();
                while (resultSet2.next()) {
                    System.out.println(resultSet2.getInt(1));
                }
                hasResults = callableStatement2.getMoreResults(); // Спрашиваем если есть еще результат.
            }

        }
    }
}
