package cz.richard808code.controller;


import cz.richard808code.dao.UserDao;
import cz.richard808code.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/list")
public class UserList extends HttpServlet {

    private final UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final User[] users = userDao.findAll();

        request.setAttribute("users", users);
        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }
}

