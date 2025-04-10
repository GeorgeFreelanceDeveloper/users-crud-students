package controller;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        final String id = req.getParameter("id");
        User user = userDao.read(Integer.parseInt(id));
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/user/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final UserDao userDao = new UserDao();
        final User user = userDao.read(Integer.parseInt(req.getParameter("id")));

        if(req.getParameter("userName") != null && !req.getParameter("userName").isEmpty()) {
            user.setUserName(req.getParameter("userName"));
        }

        if(req.getParameter("password") != null && !req.getParameter("password").isEmpty()) {
            user.setPassword(userDao.hashPasswd(req.getParameter("password")));
        }

        if(req.getParameter("email") != null && !req.getParameter("email").isEmpty()) {
            user.setEmail(req.getParameter("email"));
        }

        userDao.update(user);

        resp.sendRedirect(req.getContextPath() + "/user/list");
    }
}
