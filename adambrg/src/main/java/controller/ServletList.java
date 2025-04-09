package controller;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/user/list")
public class ServletList extends HttpServlet  {
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

       final UserDao user = new UserDao();
        request.setAttribute("users", user.findAll());
        getServletContext().getRequestDispatcher("/users/userList.jsp").forward(request, response);


    }


}


