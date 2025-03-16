import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/form")
public class UserFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            UserDao userDao = new UserDao();
            User user = userDao.getUserById(id);
            request.setAttribute("user", user);
        }

        getServletContext().getRequestDispatcher("/users/form.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String idParam = request.getParameter("id");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);

        if (idParam != null && !idParam.isEmpty()) {
            user.setId(Integer.parseInt(idParam));

            if (password == null || password.trim().isEmpty()) {
                User existingUser = userDao.getUserById(user.getId());
                user.setPassword(existingUser.getPassword());
            } else {
                user.setPassword(password);
            }

            userDao.updateUser(user);
        } else {
            if (password == null || password.trim().isEmpty()) {
                request.setAttribute("error", "Password is required for new users.");
                doGet(request, response);
                return;
            }
            user.setPassword(password);
            userDao.addUser(user);
        }

        response.sendRedirect("/user/list");
    }
}
