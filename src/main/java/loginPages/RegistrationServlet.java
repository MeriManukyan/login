package loginPages;

import classHelp.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("registerPassword");
        String name = req.getParameter("registerName");

        if (password.equals(req.getParameter("confirmPassword"))
                && !UserService.isValid(name, password)) {
            UserService.addUser(name, password);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
        requestDispatcher.include(req, resp);
    }
}
