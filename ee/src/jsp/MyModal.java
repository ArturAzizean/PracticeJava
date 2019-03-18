package jsp;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class MyModal {
    static String connectionUrl = "jdbc:mysql://localhost:3306/jdbsTest";
    static String username = "root";
    static String password = "123";

    public static int id;
    public static String getUsername;
    public static String getPassword;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = getData();
        while (resultSet.next()) {
            getUsername = resultSet.getString("name");
            System.out.println(getUsername);
            getPassword = resultSet.getString("password");
            System.out.println(getPassword);
            id = resultSet.getInt("id");
            System.out.println(id);
        }

    }

    public static ResultSet getData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password);
             Statement statement = connection.createStatement()) {

            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = factory.createCachedRowSet();

            Statement statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement2.executeQuery("select * from Users where id = 3");
            cachedRowSet.populate(resultSet);

            return cachedRowSet;
        }
//
//        try {
//            Statement statement = dbConnecter.getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//                id = resultSet.getInt("id");
//                name = resultSet.getString("name");
//                password = resultSet.getString("password");
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
