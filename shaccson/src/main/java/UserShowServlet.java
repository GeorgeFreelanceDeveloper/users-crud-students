import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/show")
public class UserShowServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            UserDao userDao = new UserDao();
            User user = userDao.getUserById(id);
            request.setAttribute("user", user);
        }

        getServletContext().getRequestDispatcher("/users/show.jsp")
                .forward(request, response);
    }
}
