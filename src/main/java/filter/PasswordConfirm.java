package filter;

import classHelp.UserService;
import com.sun.net.httpserver.HttpExchange;

import javax.servlet.*;
import java.io.IOException;

public class PasswordConfirm implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String rpassword = request.getParameter("registerPassword");
        if (!rpassword.equals(request.getParameter("confirmPassword"))
                || UserService.isValid(request.getParameter("registerName"), rpassword)) {
            response.getWriter().println("<div>error!</div>");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
