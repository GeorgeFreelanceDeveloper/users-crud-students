package controller;

import dao.UserDao;
import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/show")
public class UserShowServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String idParam = request.getParameter("id");

        if (idParam != null) {
            final int id = Integer.parseInt(idParam);
            final UserDao userDao = new UserDao();
            final User user = userDao.getUserById(id);
            request.setAttribute("user", user);
        }

        getServletContext().getRequestDispatcher("/users/show.jsp")
                .forward(request, response);
    }
}
