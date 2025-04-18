package controller;

import dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebServlet("/user/edit")
public class ServletEdit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final UserDao userDao = new UserDao();
        User user = userDao.read(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final User user = new User();
        final UserDao userDao = new UserDao();

        if (req.getParameter("userPassword") != null && !req.getParameter("userPassword").isEmpty()) {
            user.setPassword(userDao.hashPassword(req.getParameter("userPassword")));
            user.setId(Integer.parseInt(req.getParameter("id")));
            user.setUserName(req.getParameter("userName"));
            user.setEmail(req.getParameter("userEmail"));

        } else {
            user.setId(Integer.parseInt(req.getParameter("id")));
            user.setUserName(req.getParameter("userName"));
            user.setEmail(req.getParameter("userEmail"));
            user.setPassword(userDao.read(Integer.parseInt(req.getParameter("id"))).getPassword());
        }
        userDao.update(user);
        resp.sendRedirect(req.getContextPath() + "/user/list");
    }
}