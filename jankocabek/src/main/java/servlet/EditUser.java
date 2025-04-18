package servlet;

import dao.UserDao;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/edit")
public class EditUser extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final int id = Integer.parseInt(req.getParameter("userId"));
        req.setAttribute("id", id);
        final UserDao userDao = new UserDao();
        final User user = userDao.findById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/user/editUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        final UserDao userDao = new UserDao();
        final String username = req.getParameter("userName");
        final String email = req.getParameter("email");
        final int id = Integer.parseInt(req.getParameter("id"));
        final String password;
        if (req.getParameter("password") == null || req.getParameter("password").isEmpty()) {
            userDao.updateWithoutPassword(new User(id, username, email));
        } else {
            password = req.getParameter("password");
            userDao.update(new User(id, username, email, password));
        }
        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
