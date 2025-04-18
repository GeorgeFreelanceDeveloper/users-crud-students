package servlet;

import dao.UserDao;
import entity.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/add")
public class AddUser extends HttpServlet {

    @Override
    protected void doPost( HttpServletRequest req,  HttpServletResponse resp) throws  IOException {
        final UserDao dao = new UserDao();
        final String username = req.getParameter("username");
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");
        final User user = new User(username,email,password);
        dao.create(user);
        resp.sendRedirect("/main");
    }
}
