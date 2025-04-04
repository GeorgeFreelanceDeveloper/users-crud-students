package servlet;

import dao.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/login/login.jsp");
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String username = req.getParameter("userName");
        final String password = req.getParameter("password");
        final LoginDao loginDao = new LoginDao();
        final String forCompare = loginDao.checkAuth(username);
        if ((password != null && !password.isEmpty()) && BCrypt.checkpw(password, forCompare)) {
            final HttpSession session = req.getSession(true);
            session.setAttribute("username", username);
            resp.sendRedirect("/main");
        } else {
            req.setAttribute("loginError", "Invalid username or password");
            req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
        }
    }
}
