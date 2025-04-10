package controller;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/list")
public class UserList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final UserDao userDao = new UserDao();
        final List<User> users = userDao.readAll();

        if (users != null) {
            req.setAttribute("users", users);
        } else {
            req.setAttribute("users", new ArrayList<User>());
        }
        getServletContext().getRequestDispatcher("/user/list.jsp").forward(req, resp);
    }
}
