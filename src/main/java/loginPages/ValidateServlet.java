package loginPages;

import classHelp.ParseJson;
import classHelp.UserService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = new Gson().fromJson(ParseJson.readJson(req), String.class);
        final boolean isValitation = true;
        if (UserService.isValidKey(userName)) {
            resp.setHeader("status", isValitation+"");
        }
    }
}

