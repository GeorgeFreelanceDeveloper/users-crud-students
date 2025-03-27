package workshop;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        final UserDao userDao = new UserDao();
        User user = userDao.readUser(Integer.parseInt(id));
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final User user = new User();
        final UserDao userDao = new UserDao();
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setUserName(req.getParameter("userName"));
        user.setEmail(req.getParameter("email"));
        // password re-hash
        String password = req.getParameter("password");
        if (password != null && !password.isEmpty()) {
            user.setPassword(userDao.hashPassword(password));
        }
        userDao.updateUser(user);
        resp.sendRedirect("/user/list");
    }
}
