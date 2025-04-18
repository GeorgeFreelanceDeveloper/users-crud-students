package servlet.webFilter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter( ServletRequest request,  ServletResponse response,  FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final HttpServletResponse httpResponse = (HttpServletResponse) response;
        final HttpSession session = httpRequest.getSession(false);
        final String uri = httpRequest.getRequestURI();

        if (uri.startsWith("/login") || (session != null && session.getAttribute("username") != null)) {
            chain.doFilter(request, response);
        }else
        {            // Redirect to login page
            httpResponse.sendRedirect("/login");
        }
    }
}
