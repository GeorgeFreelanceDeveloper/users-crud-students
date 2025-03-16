package workshop;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDao userDao = new UserDao();
        userDao.deleteUser(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(req.getContextPath() + "/user/list.jsp");
    }
}
