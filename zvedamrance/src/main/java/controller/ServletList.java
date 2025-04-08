package controller;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import java.io.IOException;
import java.util.List;


@WebServlet("/user/list")
public class ServletList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final UserDao userDao = new UserDao();
        final List<User> userList = List.of(userDao.readAll());
        request.setAttribute("users", userList);
        getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
    }
}