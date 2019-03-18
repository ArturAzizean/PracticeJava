package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");

        resp.getWriter().write("<html>\n" +
                "<body>\n" +
                "name = " + name +
                "lastname = " + lastname +
                "\n" +
                "<h2>HTML Forms</h2>\n" +
                "\n" +
                "<form action='login' method='post'>\n" +
                "  First name:<br>\n" +
                "  <input type=\"text\" name=\"name\">\n" +
                "  <br>\n" +
                "  Last name:<br>\n" +
                "  <input type=\"text\" name=\"lastname\">\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form>" +
                "</body>" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        resp.sendRedirect("hello");
    }
}
