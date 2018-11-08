package classHelp;

import sun.plugin.javascript.navig.Array;

import java.util.*;

public class MessageService {

    public static Map<Paired, ArrayList<Message>> messages;

    static {
        messages = new HashMap<>();
    }

    public static ArrayList<Paired> getPaired(String name) {
        ArrayList<Paired> arrayList = new ArrayList<>();
        for (Map.Entry<Paired, ArrayList<Message>> entry : messages.entrySet()) {
            if (entry.getKey().content(name)) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public static void setState(Paired paired) {
        ArrayList<Message> messages = MessageService.messages.get(paired);
        Iterator<Message> iterator = messages.iterator();
        while (iterator.hasNext()) {
            iterator.next().setState(true);
        }
    }

    public static void setMessage(Paired paired, Message message) {
        if (messages.size() != 0) {
            messages.get(paired).add(message);
        }
    }

    public static ArrayList<Message> getMessageSession(Paired paired) {
        return messages.get(paired);
    }
}
