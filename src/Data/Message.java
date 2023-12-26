package Data;
import User.*;

import java.io.Serializable;

public class Message extends Data implements Serializable {
	private Employee receiver;
	
	public Message() {
        super();
    }

    public Message(User author) {
        super(author);
    }

    public Message(User author, String title) {
        super(author, title);
    }

    public Message(User author, String title, String text) {
        super(author, title, text);
    }

    public Message(User author, String title, String text, Employee receiver) {
        super(author, title, text);
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Message{" +
                "author='" + getAuthor() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", text='" + getText() + '\'' +
                ", receiver='" + getReceiver() + '\'' +
                '}';
    }

    public Employee getReceiver() {
        return receiver;
    }

    public void setReceiver(Employee receiver) {
        this.receiver = receiver;
    }
}
