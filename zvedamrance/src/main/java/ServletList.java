import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@WebServlet("/user/list")
public class ServletList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User [] users = userDao.readAll();
        List<User> userList = new ArrayList<>();
        Collections.addAll(userList, users);
        request.setAttribute("users", userList);
        for (User user : userList) {
            System.out.println(user);
        }
        getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);

    }
}