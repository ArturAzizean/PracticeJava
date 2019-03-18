package servlets;

import jsp.DbConnecter;
import jsp.MyModal;
import jsp.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/MyController")
public class MyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = null;
        try {
            ResultSet resultSet = MyModal.getData();

            student = new Student();
            student.setId(123);
            student.setName("asdasd");
            student.setPassword(resultSet.getString("password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("stud", student);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/MyView.jsp");
        requestDispatcher.forward(req, resp);
    }
}
