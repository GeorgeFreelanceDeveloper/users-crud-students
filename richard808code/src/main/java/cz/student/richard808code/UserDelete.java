package cz.student.richard808code;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {

    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            User user = userDao.read(id);

            if (user != null) {
                userDao.delete(id);
                resp.sendRedirect("/user/list");
            } else {
                resp.sendRedirect("/user/list?error=UserNotFound");
            }
        } catch (NumberFormatException e) {
            resp.sendRedirect("/user/list?error=InvalidUserId");
        }
    }
}

