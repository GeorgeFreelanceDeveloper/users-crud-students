package workshop;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final UserDao userDao = new UserDao();
        String id = request.getParameter("id");
        User readOne = userDao.readUser(Integer.parseInt(id));
        request.setAttribute("user", readOne);
        getServletContext().getRequestDispatcher("/users/show.jsp").forward(request, response);
    }
}
