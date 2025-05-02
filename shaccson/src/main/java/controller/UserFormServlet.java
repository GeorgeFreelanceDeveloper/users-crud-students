package controller;

import dao.UserDao;
import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/form")
public class UserFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String idParam = request.getParameter("id");

        if (idParam != null) {
            final int id = Integer.parseInt(idParam);
            final UserDao userDao = new UserDao();
            final User user = userDao.getUserById(id);
            request.setAttribute("user", user);
        }

        getServletContext().getRequestDispatcher("/users/form.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final UserDao userDao = new UserDao();
        final String idParam = request.getParameter("id");
        final String username = request.getParameter("username");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");

        final User user = new User();
        user.setUsername(username);
        user.setEmail(email);

        if (idParam != null && !idParam.isEmpty()) {
            user.setId(Integer.parseInt(idParam));

            if (password == null || password.trim().isEmpty()) {
                final User existingUser = userDao.getUserById(user.getId());
                user.setPassword(existingUser.getPassword());
            } else {
                user.setPassword(password);
            }

            userDao.updateUser(user);
        } else {
            if (password == null || password.trim().isEmpty()) {
                request.setAttribute("error", "Password is required for new users.");
                doGet(request, response);
                return;
            }
            user.setPassword(password);
            userDao.addUser(user);
        }

        response.sendRedirect("/user/list");
    }
}
