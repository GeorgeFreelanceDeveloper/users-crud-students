package workshop;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/user/list")
public class UserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final UserDao userDao = new UserDao();
        List<User> users = userDao.findAll();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/users/list.jsp").forward(request, response);
    }
}