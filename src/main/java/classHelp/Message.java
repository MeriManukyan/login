package classHelp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Message {

    private int id;
    private String text;
    private String receiverName;
    private String senderName;
    private Date date;
    private boolean state;

    public Message(String text, String receiverName, String senderName) {
        this.state = false;
        this.text = text;
        this.receiverName = receiverName;
        this.senderName = senderName;
        this.date = new Date();
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getSenderName() {
        return senderName;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

}
