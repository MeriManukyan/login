package loginPages;

import classHelp.UserService;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private RequestDispatcher requestDispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String registerName = session.getAttribute("userName").toString();
        String gsonUsers = new Gson().toJson(UserService.getUserFromName(registerName));
        PrintWriter writer = resp.getWriter();
        writer.write(gsonUsers);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (UserService.isValid(req.getParameter("name"), req.getParameter("password"))) {
            getSession(req, resp);
            requestDispatcher = req.getRequestDispatcher("pageOfUser.html");
            requestDispatcher.include(req, resp);
        } else {
            resp.getWriter().println("<div><div/>");
            requestDispatcher = req.getRequestDispatcher("index.html");
            requestDispatcher.include(req, resp);
            if (UserService.isValidKey(req.getParameter("name"))) {
                resp.getWriter().println("password doesn't correct");
            } else {
                resp.getWriter().println("username doesn't correct");
            }
        }
    }
    void getSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        session.setAttribute("userName", name);
    }
}
