package controller;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/delete")
public class UserDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String idParam = request.getParameter("id");

        if (idParam != null) {
            final int id = Integer.parseInt(idParam);
            final UserDao userDao = new UserDao();
            userDao.deleteUser(id);
        }

        response.sendRedirect("/user/list");
    }
}
