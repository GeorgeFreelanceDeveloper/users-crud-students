package controller;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebServlet ("/user/show")
public class ServletShow extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            final String idParam = request.getParameter("id");

            if (idParam == null || idParam.trim().isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/user/list");
                return;
            }

            try {
              final int id = Integer.parseInt(idParam);
                final UserDao userDao = new UserDao();
                final User user = userDao.read(id);

                if (user == null) {
                    response.sendRedirect(request.getContextPath() + "/user/list");
                    return;
                }

                request.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/users/userShow.jsp").forward(request, response);

            } catch (NumberFormatException e) {
                response.sendRedirect(request.getContextPath() + "/user/list");
            }
        }

}
