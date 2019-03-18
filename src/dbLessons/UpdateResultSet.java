package dbLessons;

import java.sql.*;

public class UpdateResultSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String username = "root";
        String password = "123";
        String connectionUrl = "jdbc:mysql://localhost:3306/jdbsTest";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password);
             Statement statement = connection.createStatement()) {
            statement.execute("drop table if exists Books");
            statement.executeUpdate("create table if not exists Books (id mediumint not null  auto_increment,  name char(30) not null, primary key (id))");
            statement.executeUpdate("insert into Books (name) values('Inferno')");
            statement.executeUpdate("insert into Books set name = 'Solomon'");
            statement.executeUpdate("insert into Books set name = 'Bible'");

            Statement statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement2.executeQuery("select * from Books");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }
            System.out.println("---------------------");

            resultSet.last();
            resultSet.updateString("name", "Mark (new Value)");
            resultSet.updateRow();

            resultSet.moveToInsertRow();
            resultSet.updateString("name", "John 3:16");
            resultSet.insertRow();

            resultSet.absolute(1);
            resultSet.deleteRow();

            resultSet.beforeFirst();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }
        }
    }
}
