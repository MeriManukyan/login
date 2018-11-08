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
import java.util.Iterator;

/**
 * Created by mery.manukyan on 11/5/2018.
 */
public class MessageState extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Type listType = new TypeToken<ArrayList<User>>() {}.getType();
        ArrayList<Message> messages = new Gson().fromJson(ParseJson.readJson(req), listType);
        Iterator iterator = messages.iterator();
        while (iterator.hasNext()){
            ((Message)iterator.next()).setState(true);
        }

    }
}
