package classHelp;

import java.util.Objects;

/**
 * Created by mery.manukyan on 11/5/2018.
 */
public class Paired {
    String receiverName;
    String senderName;

    public boolean content(String senderName) {
        return this.senderName.equals(senderName) || this.receiverName.equals(senderName);
    }

    public Paired(String receiverId, String senderId) {
        this.receiverName = receiverId;
        this.senderName = senderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paired paired = (Paired) o;
        return (receiverName.equals(paired.receiverName) &&
                senderName.equals(paired.senderName)) || (receiverName.equals(paired.senderName) &&
                senderName.equals(paired.receiverName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiverName, senderName);
    }
}
