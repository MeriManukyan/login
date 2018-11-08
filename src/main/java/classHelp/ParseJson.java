package classHelp;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by mery.manukyan on 10/11/2018.
 */
public class ParseJson {
    static public String readJson(HttpServletRequest req) throws IOException {
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = req.getReader();
            int ch = 0;
            char[] sb = new char[128];
            while ((ch = reader.read(sb)) != -1) {
                buffer.append(sb, 0, ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return buffer.toString();
    }
}

