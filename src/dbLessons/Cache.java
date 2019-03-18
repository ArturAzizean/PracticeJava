package dbLessons;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class Cache {
    static String connectionUrl = "jdbc:mysql://localhost:3306/jdbsTest";
    static String username = "root";
    static String password = "123";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = getData();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

    }

    static ResultSet getData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password);
             Statement statement = connection.createStatement()) {
            statement.execute("drop table if exists Books");
            statement.executeUpdate("create table if not exists Books (id mediumint not null  auto_increment,  name char(30) not null, primary key (id))");
            statement.executeUpdate("insert into Books (name) values('Inferno')");
            statement.executeUpdate("insert into Books set name = 'Solomon King'");
            statement.executeUpdate("insert into Books set name = 'Bible'");

            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = factory.createCachedRowSet();

            Statement statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement2.executeQuery("select * from Books");
            cachedRowSet.populate(resultSet);

            return cachedRowSet;
        }

    }
}
