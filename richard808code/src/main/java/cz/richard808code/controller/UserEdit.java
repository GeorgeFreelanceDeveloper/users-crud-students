package cz.richard808code.controller;


import cz.richard808code.dao.UserDao;
import cz.richard808code.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {

    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int id = Integer.parseInt(req.getParameter("id"));
        final User user = userDao.read(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/user/edit.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int id = Integer.parseInt(req.getParameter("id"));
        final String username = req.getParameter("username");
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        final User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);

        if (password != null && !password.trim().isEmpty()) {
            user.setPassword(userDao.hashPassword(password));
        } else {
            user.setPassword(userDao.read(id).getPassword());
        }

        userDao.update(user);
        resp.sendRedirect("/user/list");
    }
}

