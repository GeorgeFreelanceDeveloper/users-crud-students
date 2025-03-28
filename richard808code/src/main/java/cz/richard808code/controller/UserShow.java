package cz.richard808code.controller;


import cz.richard808code.dao.UserDao;
import cz.richard808code.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {

    private final UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int id = Integer.parseInt(request.getParameter("id"));
        final User user = userDao.read(id);
        request.setAttribute("user", user);

        request.getRequestDispatcher("/user/show.jsp").forward(request, response);
    }
}

