package dbLessons;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class DbBlob {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        String username = "root";
        String password = "123";
        String connectionUrl = "jdbc:mysql://localhost:3306/jdbsTest";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(connectionUrl, username, password);
             Statement stat = conn.createStatement()) {

            stat.executeUpdate("drop table Books");
            stat.executeUpdate("create table if not exists Books (id mediumint not null auto_increment, name char(30) not null, img blob, primary key (id))");

            BufferedImage image = ImageIO.read(new File("smile.jpg"));
            Blob blob = conn.createBlob();
            try (OutputStream outputStream = blob.setBinaryStream(1)) {
                ImageIO.write(image, "jpg", outputStream);
            }

            PreparedStatement prepareStat = conn.prepareStatement("insert into Books (name, img) values (?, ?)");
            prepareStat.setString(1, "inferno");
            prepareStat.setBlob(2, blob);
            prepareStat.execute();

            ResultSet resultSet = stat.executeQuery("select * from Books");
            while (resultSet.next()) {
                Blob blob1 = resultSet.getBlob("img");
                BufferedImage image1 = ImageIO.read(blob1.getBinaryStream());
                File saved = new File("saved.png");
                ImageIO.write(image1, "png", saved);
            }
        }
    }
}
