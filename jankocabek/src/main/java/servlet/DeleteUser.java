package servlet;

import dao.UserDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/delete")
public class DeleteUser extends HttpServlet {

    @Override
    protected void doPost( HttpServletRequest req,  HttpServletResponse resp) throws  IOException {
        final int id = Integer.parseInt(req.getParameter("userId"));
        final UserDao userDao = new UserDao();
        userDao.delete(id);
        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
