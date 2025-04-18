package controller;
import dao.UserDao;
import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/add")
public class ServletAdd extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/users/userAdd.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String userName = request.getParameter("userName");
        final String userEmail = request.getParameter("userEmail");
        final String userPassword = request.getParameter("userPassword");

        if (userName == null || userName.trim().isEmpty() ||
                userEmail == null || userEmail.trim().isEmpty() ||
                userPassword == null || userPassword.trim().isEmpty()) {

            request.setAttribute("errorMessage", "All fields are required.");
            getServletContext().getRequestDispatcher("/users/userAdd.jsp").forward(request, response);
            return;
        }

        final User user = new User();
        user.setUserName(userName);
        user.setEmail(userEmail);
        user.setPassword(userPassword);

        final UserDao userDao = new UserDao();
        userDao.create(user);

        response.sendRedirect(request.getContextPath() + "/user/list");
    }
}
