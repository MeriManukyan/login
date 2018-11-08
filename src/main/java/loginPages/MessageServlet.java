package loginPages;

import classHelp.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Message> currentMessages;
        resp.setContentType("text/plain");
        Gson gson = new Gson();
        Message message = gson.fromJson(ParseJson.readJson(req), Message.class);
        String receiver = message.getReceiverName();
        String messageContent = message.getText();
        String sender = (String) req.getSession().getAttribute("userName");
        Paired paired = new Paired(receiver, sender);
        if (messageContent != null && !messageContent.equals("")) {
            MessageService.setMessage(paired, new Message(messageContent, receiver, sender));
        }
        currentMessages = MessageService.getMessageSession(paired);

        resp.getWriter().append(gson.toJson(currentMessages));
    }


}
